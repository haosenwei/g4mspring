package com.g4m.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/7/19 23:33
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Component
public class RtmpTask {

    private static final Logger log = LogManager.getLogger(RtmpTask.class);

    protected ExecutorService executor = Executors.newFixedThreadPool(1);
    private static Set<Change> changeSet = new HashSet<>();
    private String urls[];
    private String rtmp;
    private int index;

    public void change(String[] url, String rtmp, int index) throws InterruptedException {
        for (Change change : changeSet) {
            change.setPleaseStop();
        }
        changeSet.clear();
        Thread.sleep(1000L);
        Change change = new Change();
        changeSet.add(change);
        this.urls = url;
        this.rtmp = rtmp;
        this.index = index;
        executor.execute(change);
    }

    public void change(String url[]) throws InterruptedException {
        for (Change change : changeSet) {
            change.setPleaseStop();
        }
        changeSet.clear();
        Thread.sleep(1000L);
        Change change = new Change();
        changeSet.add(change);
        this.urls = url;
        executor.execute(change);
    }


    class Change implements Runnable {
        private volatile boolean pleaseStop = false;
        private volatile Process pro;

        @Override
        public void run() {

            while (true) {
                if (index >= urls.length) {
                    index = 0;
                    System.out.println("跳出");
                    break;
                }
                String currentUrl = urls[index];
                if (pleaseStop) {
                    log.debug("stop exit");
                    return;
                }
                String[] commend = {"/bin/sh", "-c", "ffmpeg -re -i \"" + currentUrl + "\" -vcodec copy -acodec aac -b:a 192k -f flv \"" + rtmp + "\""};
                System.out.println(JSONObject.toJSON(commend));
                try {
                    pro = Runtime.getRuntime().exec(commend);
//                    pro.waitFor();
                    System.out.println("开始直播");
                    InputStream in = pro.getInputStream();
                    BufferedReader read = new BufferedReader(new InputStreamReader(in));

                    String line = null;
                    while ((line = read.readLine()) != null) {
                        log.debug(line);
                        if (pleaseStop) {
                            break;
                        }
                    }
                    log.debug("jieshu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                index = index + 1;
            }
        }

        public void setPleaseStop() {
            this.pleaseStop = true;
            if (pro != null) {
                pro.destroy();
            }
        }
    }
}

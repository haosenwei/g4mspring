package com.g4m.util;

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
    private String url;
    private String rtmp;

    public void change(String url, String rtmp) throws InterruptedException {
        for (Change change : changeSet) {
            change.setPleaseStop();
        }
        changeSet.clear();
        Thread.sleep(1000L);
        Change change = new Change();
        changeSet.add(change);
        this.url = url;
        this.rtmp = rtmp;
        executor.execute(change);
    }

    public void change(String url) throws InterruptedException {
        for (Change change : changeSet) {
            change.setPleaseStop();
        }
        changeSet.clear();
        Thread.sleep(1000L);
        Change change = new Change();
        changeSet.add(change);
        this.url = url;
        executor.execute(change);
    }


    class Change implements Runnable {
        private volatile boolean pleaseStop = false;

        @Override
        public void run() {
            while (true) {
                if (pleaseStop) {
                    System.out.println("stop exit");
                    return;
                }
                String commend = "ffmpeg -re -i \"" + url + "\" -vcodec copy -acodec aac -b:a 192k -f flv \"" + rtmp + "\"";
                Process pro = null;
                try {
                    pro = Runtime.getRuntime().exec(commend);
                    pro.waitFor();

                    InputStream in = pro.getInputStream();
                    BufferedReader read = new BufferedReader(new InputStreamReader(in));

                    String line = null;
                    while ((line = read.readLine()) != null) {
                        log.debug(line);
                        if (pleaseStop) {
                            break;
                        }
                    }
                    log.debug("结束");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setPleaseStop() {
            this.pleaseStop = true;
        }
    }
}

package com.g4m.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/18/19 18:39
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
public class RtmpExecTask implements Runnable {

    private static final Logger log = LogManager.getLogger(RtmpExecTask.class);


    private String currentUrl;
    private String rtmp;

    public RtmpExecTask(String currentUrl, String rtmp) {
        this.currentUrl = currentUrl;
        this.rtmp = rtmp;
    }

    @Override
    public void run() {
        Process pro = null;
        try {
            String[] commend = {"/bin/sh", "-c", "ffmpeg -re -i \"" + currentUrl + "\" -vcodec copy -acodec aac -b:a 192k -f flv \"" + rtmp + "\""};
            log.debug("url:{}  begin", currentUrl);
            pro = Runtime.getRuntime().exec(commend);
            dealStream(pro);
            pro.waitFor();
            pro.destroy();
            log.debug("url:{} end", currentUrl);
        } catch (IOException | InterruptedException e) {
            try {
                pro.getErrorStream().close();
                pro.getInputStream().close();
                pro.getOutputStream().close();
            } catch (Exception ee) {
            }

            log.debug("url:{} fail", currentUrl);
        }
    }

    private static void dealStream(Process process) {
        if (process == null) {
            return;
        }
        // 处理InputStream的线程
        new Thread() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                try {
                    while ((line = in.readLine()) != null) {
                        log.info("output: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        // 处理ErrorStream的线程
        new Thread() {
            @Override
            public void run() {
                BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = null;
                try {
                    while ((line = err.readLine()) != null) {
                        log.info("err: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        err.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

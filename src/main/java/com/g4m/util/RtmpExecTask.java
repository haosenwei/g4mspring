package com.g4m.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/18/19 18:39
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
public class RtmpExecTask implements Runnable {

    private static final Logger log = LogManager.getLogger(RtmpExecTask.class);

    private Process pro;
    private String currentUrl;
    private String rtmp;

    public RtmpExecTask(String currentUrl, String rtmp) {
        this.currentUrl = currentUrl;
        this.rtmp = rtmp;
    }


    @Override
    public void run() {

        String[] commend = {"/bin/sh", "-c", "ffmpeg -re -i \"" + currentUrl + "\" -vcodec copy -acodec aac -b:a 192k -f flv \"" + rtmp + "\""};
        try {
            log.debug("url:{}.begin", currentUrl);
            pro = Runtime.getRuntime().exec(commend);
            pro.waitFor();
            InputStream in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while ((line = read.readLine()) != null) {
                log.debug(line);
            }
            log.debug("url:{}.end", currentUrl);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

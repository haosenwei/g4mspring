package com.g4m.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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
            pro.waitFor();
            pro.destroy();
            log.debug("url:{} 播放结束", currentUrl);
        } catch (IOException | InterruptedException e) {
            try {
                pro.getErrorStream().close();
                pro.getInputStream().close();
                pro.getOutputStream().close();
            } catch (Exception ee) {
            }

            log.debug("url:{} 播放失败", currentUrl);
        }
    }
}

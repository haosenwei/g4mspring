package com.g4m.util;


import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/7/19 23:33
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Component
public class RtmpTask {


    protected ExecutorService executor = Executors.newFixedThreadPool(1);

    public void addTask(String url, String rtmp) {
        RtmpExecTask rtmpExecTask = new RtmpExecTask(url, rtmp);
        executor.execute(rtmpExecTask);
    }

    public int getActiveCount() {
        int threadCount = ((ThreadPoolExecutor) executor).getActiveCount();
        return threadCount;
    }
}

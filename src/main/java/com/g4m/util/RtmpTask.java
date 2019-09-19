package com.g4m.util;


import com.g4m.base.G4mConstants;
import com.g4m.entity.Config;
import com.g4m.entity.Video;
import com.g4m.mapper.ConfigMapper;
import com.g4m.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private VideoMapper videoMapper;

    protected ExecutorService executor = Executors.newFixedThreadPool(1);

    public void addTask(String url, String rtmp) {
        RtmpExecTask rtmpExecTask = new RtmpExecTask(url, rtmp);
        executor.execute(rtmpExecTask);
    }

    public int getActiveCount() {
        int threadCount = ((ThreadPoolExecutor) executor).getActiveCount();
        return threadCount;
    }

    public void start(String rtmp) {
        Config byCode = configMapper.getByCode(G4mConstants.bilibiliRtmp);
        if (byCode == null) {
            byCode = new Config();
            byCode.setCode(G4mConstants.bilibiliRtmp);
            byCode.setConfigValue(rtmp);
            configMapper.insertUseGeneratedKeys(byCode);
        } else {
            byCode.setConfigValue(rtmp);
            configMapper.updateByPrimaryKey(byCode);
        }
        int activeCount = getActiveCount();
        if (activeCount < 5) {
            List<Video> avilableList = videoMapper.getAvilableList();
            if (avilableList != null && avilableList.size() > 0) {
                for (Video video : avilableList) {
                    addTask(video.getUrl(), byCode.getConfigValue());
                    videoMapper.updateCount(video.getId());
                }
            }
        }
    }

    public void addVideo() {
        int activeCount = getActiveCount();
        if (activeCount < 5) {
            Config config = configMapper.getByCode(G4mConstants.bilibiliRtmp);
            if (config == null) {
                return;
            }
            List<Video> avilableList = videoMapper.getAvilableList();
            if (avilableList != null && avilableList.size() > 0) {
                for (Video video : avilableList) {
                    addTask(video.getUrl(), config.getConfigValue());
                    videoMapper.updateCount(video.getId());
                }
            }
        }
    }
}

package com.g4m.task;

import com.g4m.entity.Config;
import com.g4m.entity.Video;
import com.g4m.mapper.ConfigMapper;
import com.g4m.mapper.VideoMapper;
import com.g4m.util.RtmpTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/19/19 13:48
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private RtmpTask rtmpTask;

    @Autowired
    private ConfigMapper configMapper;

    //3.添加定时任务
    @Scheduled(cron = "0 0/5 * * * ?")
    //或直接指定时间间隔，例如：5分钟
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        rtmpTask.addVideo();
    }
}

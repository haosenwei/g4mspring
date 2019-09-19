package com.g4m.test;

import com.g4m.Application;
import com.g4m.entity.Video;
import com.g4m.mapper.VideoMapper;
import com.g4m.util.RtmpTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/19/19 14:05
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class TestMain {

    @Autowired
    private RtmpTask rtmpTask;

    @Test
    public void testOne() {
        rtmpTask.start("rtmp://js.live-send.acg.tv/live-js/?streamname=live_371910283_18155090&key=bfcd6a96b43bfb0ad51a189db3ebf18a");
    }
}

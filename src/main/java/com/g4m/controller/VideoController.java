package com.g4m.controller;

import com.g4m.entity.Video;
import com.g4m.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/19/19 11:09
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@RestController
public class VideoController {

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("/videos")
    public List<Video> getVideos() {
        return videoMapper.selectAll();
    }
}

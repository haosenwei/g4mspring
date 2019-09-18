package com.g4m.controller;

import com.g4m.util.RtmpTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 8/30/19 14:03
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@RestController
public class RecieveStringController {

    private static final Logger log = LogManager.getLogger(RecieveStringController.class);

    @Autowired
    RtmpTask rtmpTask;

    @RequestMapping("/str")
    public String getString(@RequestParam(name = "str", defaultValue = "") String str) {
        if (str != null && !"".equals(str)) {
            log.info("str:{}", str);
        }
        return "OK";
    }

    @RequestMapping("/setToken")
    public String shShell(@RequestParam(name = "url") String url, @RequestParam(name = "rtmp") String rtmp) {
        log.info("url:{},rtmp:{}", url, rtmp);
        rtmpTask.addTask(url, rtmp);
        return "OK";
    }
}

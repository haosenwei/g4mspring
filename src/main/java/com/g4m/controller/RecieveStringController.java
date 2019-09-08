package com.g4m.controller;

import com.g4m.util.GpioUtil;
import com.g4m.util.HttpUtil;
import com.g4m.util.RtmpTask;
import com.pi4j.io.gpio.PinState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    GpioUtil gpioUtil;

    @RequestMapping("/str")
    public String getString(@RequestParam(name = "str", defaultValue = "") String str) {
        if (str != null && !"".equals(str)) {
            log.info("str:{}", str);
        }
        return "OK";
    }


    @RequestMapping("/setValue")
    public String setValue(@RequestParam(name = "id") String id, @RequestParam(name = "nid") String nid) {
        log.info("id:{},nid:{}", id, nid);
        if (id != null && !"".equals(id)) {
            String[] split = id.split(",");
            for (String a : split) {
                Integer integer = Integer.valueOf(a);
                gpioUtil.setValue(integer, PinState.HIGH);
            }
        }
        if (nid != null && !"".equals(nid)) {
            String[] split = nid.split(",");
            for (String b : split) {
                Integer integer = Integer.valueOf(b);
                gpioUtil.setValue(integer, PinState.LOW);
            }
        }
        return "OK";
    }

    @RequestMapping("/lcdOperation")
    public String lcdOperation(@RequestParam(name = "id") String id) {
        log.info("id:{},nid:{}", id);
        String[] split = id.split(",");
        if (split.length != 10) {
            return "参数错误";
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            data.add(Integer.valueOf(split[i]));
        }
        gpioUtil.setLcdValue(data.get(0),
                data.get(1),
                data.get(2),
                data.get(3),
                data.get(4),
                data.get(5),
                data.get(6),
                data.get(7),
                data.get(8),
                data.get(9));
        return "OK";
    }

    @RequestMapping("/rtmp")
    public String shShell(@RequestParam(name = "url") int url, @RequestParam(name = "rtmp") String rtmp, @RequestParam(name = "index", defaultValue = "0") int index) {
        log.info("url:{},rtmp:{}", url, rtmp);
        try {
            String[] url1 = HttpUtil.getUrl(url);
            rtmpTask.change(url1, rtmp, index);
        } catch (Exception e) {
            log.error("播放失败");
            e.printStackTrace();
            return "ERROR" + e.getMessage();
        }
        return "OK";
    }
}

package com.g4m.controller;

import com.g4m.util.GpioUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 8/30/19 14:03
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@RestController
public class RecieveStringController {

    private static final Logger log = LogManager.getLogger(RecieveStringController.class);

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
                gpioUtil.setValue(integer, 1);
            }
        }
        if (nid != null && !"".equals(nid)) {
            String[] split = nid.split(",");
            for (String b : split) {
                Integer integer = Integer.valueOf(b);
                gpioUtil.setValue(integer, 0);
            }
        }
        return "OK";
    }

    @RequestMapping("/getValue")
    public Map<Integer, Object> getValue() {
        Map<Integer, Object> value = gpioUtil.getValue();
        return value;
    }

    @RequestMapping("/clear")
    public boolean clear() {
        boolean value = gpioUtil.clear();
        return value;
    }
}

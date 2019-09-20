package com.g4m.controller;

import com.g4m.util.RtmpTask;
import com.g4m.util.TestJsoupParseHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 10:47
 */
@Controller
public class IndexController {

    @Autowired
    private RtmpTask rtmpTask;

    @Autowired
    private TestJsoupParseHtml testJsoupParseHtml;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("userName", "蝈蝈");
        return view;
    }

    @ResponseBody
    @RequestMapping("/startVideo")
    public String startVideo(@RequestParam(name = "rtmp") String rtmp) {
        rtmpTask.start(rtmp);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/start")
    public String start() {
        testJsoupParseHtml.start();
        return "OK";
    }
}

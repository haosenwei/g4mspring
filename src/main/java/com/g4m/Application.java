package com.g4m;

import com.g4m.controller.RecieveStringController;
import com.g4m.util.HttpUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("启动成功");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return "hello";
    }

    @RequestMapping("/lcd")
    public String a() {
        return "a";
    }

    @RequestMapping("/roomId")
    public String setRoomId() {
        return "room";
    }
}


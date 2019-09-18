//package com.g4m.init;
//
//import com.g4m.util.AddressUtils;
//import com.g4m.util.MailUtil;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.net.SocketException;
//
///**
// * @author haosenwei[haosenwei@dubmic.com]
// * @date 9/1/19 20:27
// * <p>Copyright 2008-2019 snsndk.com</p>
// */
//@Component
//public class SendEmail {
//    @PostConstruct
//    public void sendEmail() {
//        String ip = "";
//        try {
//            ip = "ip:" + AddressUtils.getInnetIp() + ". thank u";
//        } catch (SocketException e) {
//            ip = "get ip fail";
//        }
////        MailUtil.sendEmail("shumeipai get ip", ip, "961970674@qq.com");
//        System.out.println(ip);
//    }
//}

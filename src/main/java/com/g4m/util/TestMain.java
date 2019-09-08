//package com.g4m.util;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
///**
// * @author haosenwei[haosenwei@dubmic.com]
// * @date 9/8/19 15:31
// * <p>Copyright 2008-2019 snsndk.com</p>
// */
//public class TestMain {
//    public static void main(String[] args) throws InterruptedException, IOException {
//        Document document = Jsoup.connect("https://live.bilibili.com/21461248").get();
////        System.out.println(document.toString());
//        Elements elements = document.select("div.script-requirement");
//        Element element = elements.get(0).selectFirst("script");
//        if (element != null) {
//            String str = element.data();
//            str = str.replace("window.__NEPTUNE_IS_MY_WAIFU__=", "");
//            JSONObject jsonObject = JSONObject.parseObject(str);
//            JSONArray jsonArray = jsonObject.getJSONObject("playUrlRes").getJSONObject("data").getJSONArray("durl");
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                String url = jsonObject1.getString("url");
//                System.out.println(url);
//            }
//        }
//
//    }
//}

package com.g4m.util;

import com.g4m.util.EmojiFilter;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.io.*;


/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/20/19 12:53
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Component
public class TestJsoupParseHtml {

    private DriverManagerDataSource dataSource = null;


    public void start() {
        System.out.println("helloworld");
        String[] aa = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
        int i = 0;
        for (int i1 = 0; i1 < aa.length; i1++) {
            String first = aa[i1];
            for (int i2 = 0; i2 < aa.length; i2++) {
                for (int i3 = 0; i3 < aa.length; i3++) {
                    for (int i4 = 0; i4 < aa.length; i4++) {
                        for (int i5 = 0; i5 < aa.length; i5++) {
                            for (int i6 = 0; i6 < aa.length; i6++) {
                                String code = first + aa[i2] + aa[i3] + aa[i4] + aa[i5] + aa[i6];
                                getgeUrl(code);
                            }
                        }
                    }
                }
            }
        }
    }

    private void getgeUrl(String code) {
        String url = "http://v.douyin.com/" + code + "/";
        String encoding = "utf-8";
        try {
            String html = getHTMLResourceByUrl(code, url);

            if (html != null) {
                System.out.println("success:" + code + ",url:" + html);
            } else {
                System.out.println("结果为空:" + code + ",url:");
            }
        } catch (Exception e) {
            System.out.println("error,code:" + code + ",e:" + e.getMessage());
        }
    }


    public String getVideoUrl(String html) {
        int playAddr = html.indexOf("playAddr");
        int cover = html.indexOf("cover");
        if (playAddr > 0 && cover > 0) {
            String substring = html.substring(playAddr, cover);
            return substring.replace("playAddr: \"", "").replace("\",", "");
        }
        return null;
    }

    //获取html
    public String getHTMLResourceByUrl(String code, String url) {
        Connection connect = Jsoup.connect(url);
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException e) {
            System.out.println("请求失败，code:" + code + ",e:" + e.getMessage());
            return null;
        }
        String name = document.select("#pageletReflowVideo > div > div.info-box.fl > div.video-info > div > div.info > p").html();
        String headImg = document.select("#pageletReflowVideo > div > div.info-box.fl > div.video-info > div > div.avatar.fl > img").attr("src");
        String desc = document.select("#pageletReflowVideo > div > div.info-box.fl > div.video-info > p").html();
        String cover = document.select("#pageletReflowVideo > div > div.video-box.fl > div").attr("style");
        String video = getVideoUrl(document.toString());
        if (StringUtils.isNotBlank(video)) {
            try {
                addToMysql(code, name, video, desc, cover, headImg);
            } catch (Exception e) {
                System.out.println("error:" + code + "-" + name + "-" + video + "-" + desc + "-" + cover + "-" + headImg + ",e:" + e.getMessage());
                writeToFile("error:" + code + "-" + name + "-" + video + "-" + desc + "-" + cover + "-" + headImg + ",e:" + e.getMessage());
            }
        }
        return video;
    }

    private void writeToFile(String str) {
        //需要写入的文件的路径
        String filePath = "/Users/yixia/Desktop/error.txt";
        if (StringUtils.isBlank(str)) {
            return;
        }

        try {
            File file = new File(filePath);
            FileOutputStream fos = null;
            if (!file.exists()) {
                file.createNewFile();//如果文件不存在，就创建该文件
                fos = new FileOutputStream(file);//首次写入获取
            } else {
                //如果文件已存在，那么就在文件末尾追加写入
                fos = new FileOutputStream(file, true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
            }

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件
            osw.write(str.trim() + ",");

            //每写入一个Map就换一行
            osw.write("\r\n");
            //写入完成关闭流
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addToMysql(String code, String name, String videoUrl, String desc, String cover, String head_cover) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.execute("INSERT INTO `video_play`.`douyin_video`(`code`, `user_name`, `video_url`, `desc`, `cover`,`head_cover`) " +
                "VALUES (  '" + code + "', '" + EmojiFilter.filterEmoji(name) + "','" + videoUrl + "', '" + EmojiFilter.filterEmoji(desc) + "', '" + cover + "','" + head_cover + "');");
    }

    private DriverManagerDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:33306/video_play?useUnicode=true&characterEncoding=utf8&useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
        }
        return dataSource;
    }
}


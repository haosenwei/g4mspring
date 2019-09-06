package com.g4m.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/6/19 14:32
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
public class ShellUtil {
    public String shShell(String[] cmds) throws IOException, InterruptedException {
        Process pro = Runtime.getRuntime().exec(cmds);
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = read.readLine()) != null) {
            return line;
        }
        return line;
    }

    public static void changeUrl(String fileUrl, String rtmp) throws IOException, InterruptedException {
        String[] getPidCmds = {"/bin/sh", "-c", "ps -ef | grep ffmpeg | grep -v grep | awk '{print $2}'"};
        Process pro = Runtime.getRuntime().exec(getPidCmds);
        pro.waitFor();
        InputStream in = pro.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = read.readLine()) != null) {
            String[] stopCmds = {"/bin/sh", "-c", "kill -9 " + line};
            Runtime.getRuntime().exec(stopCmds);
            break;
        }
        String commend = "ffmpeg -re -stream_loop -1 -i \"" + fileUrl + "\" -vcodec copy -acodec aac -b:a 192k -f flv \"" + rtmp + "\"";
        String[] startCmds = {"/bin/sh", "-c", commend};
        Runtime.getRuntime().exec(startCmds);
    }
}

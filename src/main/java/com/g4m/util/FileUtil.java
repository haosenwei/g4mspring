package com.g4m.util;

import java.io.*;

class FileUtil {
    static void append(String file, byte[] appendBytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write(appendBytes);
        outputStream.close();
    }

    static void replace(String file, byte[] replaceBytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file, false);
        outputStream.write(replaceBytes);
        outputStream.close();
    }

    static byte[] readBytes(String file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }
}
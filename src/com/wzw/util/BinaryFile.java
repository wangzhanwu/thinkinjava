package com.wzw.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取二进制文件
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        } finally {
            in.close();
        }
    }

    public static byte[] read(String fileName) throws IOException {
        return read(new File(fileName));
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\util\\TextFile.java";
        byte[] data = read(filePath);
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : data) {
            Integer count = map.get(b);
            map.put(b, count == null ? 1 : count + 1);
        }
        System.out.println(map);
    }
}

package com.wzw.ios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data.txt";
    private static String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data2.txt";

    public static void main(String[] args) throws IOException {
        FileChannel
                in = new FileInputStream(filePath).getChannel(),
                out = new FileOutputStream(filePath2).getChannel();

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        while ((in.read(buff)) != -1) {
            buff.flip();
            out.write(buff);
            buff.clear();//将限制设置为容量，位置设置为0
        }
        in.close();
        out.close();
    }
}

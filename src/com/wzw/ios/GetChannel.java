package com.wzw.ios;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data.txt";
    private static String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data2.txt";
    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new RandomAccessFile(filePath, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" Some more".getBytes()));
        fc.close();

        fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();//将缓冲区的限制设置为当前位置，位置设置为0 准备读取缓冲区中的数据
        while(buff.hasRemaining()) {
            System.out.println((char)buff.get());
        }
    }
}

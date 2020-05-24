package com.wzw.ios;

import sun.nio.ch.FileChannelImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data3.txt";

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some Text".getBytes()));
        fc.close();
        fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + " : " + Charset.forName(encoding).decode(buff));

        fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some Other Text".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream(filePath).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        fc = new FileOutputStream(filePath).getChannel();
        buff = ByteBuffer.allocate(1024);
        buff.asCharBuffer().put("Some Text");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream(filePath).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}

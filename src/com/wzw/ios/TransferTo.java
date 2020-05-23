package com.wzw.ios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    private static final int BSIZE = 1024;
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data.txt";
    private static String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data2.txt";

    public static void main(String[] args) throws IOException {
        FileChannel
                in = new FileInputStream(filePath).getChannel(),
                out = new FileOutputStream(filePath2).getChannel();
        in.transferTo(0, in.size(), out);
//        out.transferFrom(in, 0, in.size());
        in.close();
        out.close();
    }


}

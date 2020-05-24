package com.wzw.ios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLocks {
    private static String  filePath= "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data5.txt";
    public static void main(String[] args) throws IOException, InterruptedException {
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        FileLock fl = fc.tryLock();
        if(fl!=null) {
            System.out.println("Locked File");
            Thread.sleep(2000);
            fl.release();
            System.out.println("Release Lock");
        }
        fc.close();
    }
}

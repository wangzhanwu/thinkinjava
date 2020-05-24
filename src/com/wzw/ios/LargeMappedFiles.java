package com.wzw.ios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF;
    private static String  filePath= "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data4.txt";
    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile(filePath, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        System.out.println("Finshing Writing");
        for (int i = length/2; i < length/2+6; i++) {
            System.out.println((char)out.get(i));
        }
    }
}

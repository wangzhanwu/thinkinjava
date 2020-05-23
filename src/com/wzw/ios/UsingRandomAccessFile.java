package com.wzw.ios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    private static final String filename = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(filename, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < 7; i++) {
            raf.writeDouble(i*1.414);
        }
        raf.writeUTF("The end of the file");
        raf.close();
        display();

        raf = new RandomAccessFile(filename, "rw");
        raf.seek(5 * 8);
        raf.writeDouble(47.000001);
        raf.close();
        display();
    }
}

package com.wzw.ios;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
    static String filename = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\BufferedInputFile.java";
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(filename).getBytes()));
        while (in.available() != 0) {
            System.out.println((char)in.readByte());
        }
    }
}

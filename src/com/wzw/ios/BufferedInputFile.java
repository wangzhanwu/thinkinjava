package com.wzw.ios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder result = new StringBuilder();
        while((s=in.readLine()) != null) {
            result.append(s + "\n");
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\BufferedInputFile.java"));
    }
}

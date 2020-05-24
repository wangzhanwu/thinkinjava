package com.wzw.ios;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress {
    private static String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data4.txt";
    private static String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\data4.gz";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(filePath2)));
        System.out.println("Writing File");
        int c;
        while((c= in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        System.out.println("Reading File");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(filePath2))));
        String s;
        while((s=in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}

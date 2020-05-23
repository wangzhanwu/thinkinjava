package com.wzw.ios;

import com.wzw.util.Print;

import java.io.*;

public class BasicOutputFile {
    private static final String filename = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\BasicOutputFile.java";
    private static final String outname = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\BasicOutputFile.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(filename)));

//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outname)));
//        PrintWriter out = new PrintWriter(outname);
//        BufferedWriter out = new BufferedWriter(new FileWriter(outname));
        FileWriter out = new FileWriter(outname);
        int lineCount = 1;
        String s;
        while ((s=in.readLine()) != null) {
//            out.println(lineCount++ + " " + s);
            out.write(lineCount++ + " " + s);
//            out.newLine();
        }
        out.close();
        System.out.println(BufferedInputFile.read(outname));
    }

}

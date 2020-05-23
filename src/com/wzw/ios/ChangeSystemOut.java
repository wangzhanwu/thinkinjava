package com.wzw.ios;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintStream ps = new PrintStream(System.out);
        ps.println("abcd");
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello World!");


    }
}

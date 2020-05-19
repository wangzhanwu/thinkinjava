package com.wzw.util;

import java.io.PrintStream;

public class Print {

    public static void print(Object args) {
        System.out.println(args);
    }

    public static void print() {
        System.out.println();
    }

    public static void printnb(Object args) {
        System.out.print(args);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);

    }
}

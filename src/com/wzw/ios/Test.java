package com.wzw.ios;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        String s = System.getProperty("user.dir");
        System.out.println(s);

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
}

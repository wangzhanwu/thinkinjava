package com.wzw.main;

import java.time.LocalDate;

public class Learn1 {

    static{
        str = "edf";
    }
    private static String str = "abc";

    {
        inst = "456";
    }
    private String inst = "123";


    Learn1(String str) {
        System.out.println("construct args: "+str);
    }

    public static void main(String[] args) {
//        Learn1[] array = new Learn1[10];
//        array[0] = new Learn1("abc");
//        LocalDate.now();
        System.out.println(str);
        System.out.println(new Learn1("").inst);
        System.gc();

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("回收");
    }
}

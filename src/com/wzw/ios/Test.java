package com.wzw.ios;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\worm.out";
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        String s = (String) is.readObject();
        Object w1 = is.readObject();
        System.out.println(w1.getClass());
        System.out.println(s);
        System.out.println("w1="+w1);
    }
}

package com.wzw.strings;

public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        float y = 3.1415f;
        System.out.println("Row 1:["+x +" "+y +"]");
        System.out.format("Row 1:[%d %f]\n", x,y);
        System.out.printf("Row 1:[%d %f]\n", x,y);
    }
}

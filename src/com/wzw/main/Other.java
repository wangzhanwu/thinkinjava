package com.wzw.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Other {
    int a;
    char b;
    public int i = 0;
    Tank2 tank2;

    /**
     * TODO: WZW 2020-04-27
     * FIXME
     * @param args
     */
    public static void main(String[] args) {
        int s=1831;
        int g = s%10;
        int sw= s/10%10;
        int b = s/100%10;
        int q = s/1000%10;
        System.out.println("个位数度是知:"+g+";十位道数是:"+sw+";百位数是："+b+";千位容数是："+q);
       //fibonacci(20);
//        fibo(10);
//        int[] a = fibo1();
//        System.out.println(Arrays.toString(a));
//        xxg1();

        Other other = new Other();
        other.increment().increment().increment().print();
    }

    Other increment() {
        i++;
        return this;
    }

    void print() {
        System.out.println(i);
    }

    static void xxg1() {
        for (int i = 1000; i <= 9999; i++) {
            if (i%100 == 0) {
                continue;
            }
            for (int j = 10; j <= 99; j++) {
                for (int k = 10; k <= 99; k++) {
                    if (i == j*k) {
                        String[] arr1 = String.valueOf(i).split("");
                        String[] arr2 = String.valueOf(j+""+k).split("");
                        Arrays.sort(arr1);
                        Arrays.sort(arr2);
                        if (Arrays.equals(arr1, arr2)) {
                            System.out.println(i+","+j+","+k);
                        }
                    }
                }
            }
        }
    }

    static void fibonacci(int count) {
        int a = 1, b = 1, c = 0;
        for (int i = 0; i < count; i++) {
            if (i == 0 || i == 1) {
                System.out.println(1);
                continue;
            }
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    static void fibo(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(fibo_algorithm(i));
        }
    }

    static int fibo_algorithm(int i) {
        if(i==0 || i==1) {
            return 1;
        }
        return fibo_algorithm(i-1) + fibo_algorithm(i-2);
    }

    static int[] fibo1() {
        int[] a = new int[20];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a;
    }
}


package com.wzw.generics;

public class Fibonacci2 {
    int a = 1;
    int b = 1;
    int t;

    public int next(int i) {
        if (i<2) return 1;
        t = b;
        b = a + b;
        a = t;
        return b;
    }

    public static void main(String[] args) {
        Fibonacci2 fibo = new Fibonacci2();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibo.next(i));
        }
    }
}

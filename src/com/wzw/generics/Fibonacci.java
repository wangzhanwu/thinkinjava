package com.wzw.generics;

import com.wzw.util.Generator;

public class Fibonacci implements Generator<Integer> {
    private Integer count = 0;

    public Integer next() {
        return fib(count++);
    }
    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibo.next());
        }
    }
}

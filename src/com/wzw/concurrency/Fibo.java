package com.wzw.concurrency;

import com.wzw.generics.Fibonacci;

public class Fibo implements Runnable{
    protected int n = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public Fibo(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        Fibonacci fibo = new Fibonacci();
        StringBuilder result = new StringBuilder("#");
        result.append(id);
        result.append("#");
        for (int i = 0; i < n; i++) {
            result.append(fibo.next());
        }
        System.out.println(result.toString());
    }
}

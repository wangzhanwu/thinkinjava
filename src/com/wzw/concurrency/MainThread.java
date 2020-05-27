package com.wzw.concurrency;

public class MainThread {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Fibo(12)).start();
        }
    }
}

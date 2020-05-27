package com.wzw.concurrency;

public class TheadOnly extends Thread {
    static int count = 0;
    @Override
    public void run() {
        System.out.print(count++ + " ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TheadOnly().start();
        }
    }
}



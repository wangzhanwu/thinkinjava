package com.wzw.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator gen, int ident) {
        generator = gen;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val%2 != 0) {
                System.out.println(val + " is not even");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executor.execute(new EvenChecker(generator, i));
        }
        executor.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}

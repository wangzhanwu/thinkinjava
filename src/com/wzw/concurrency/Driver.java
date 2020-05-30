package com.wzw.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch done = new CountDownLatch(10);
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(new Worker(start, done));
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("开始执行");
        start.countDown();
        done.await();
        System.out.println("所有任务执行完成");
        executor.shutdownNow();
    }


}

class Worker implements Runnable {
    private CountDownLatch start;
    private CountDownLatch done;
    public Worker(CountDownLatch start, CountDownLatch done) {
        this.start = start;
        this.done = done;
    }

    @Override
    public void run() {
        try {
            start.await();
            System.out.println("do something");
            TimeUnit.SECONDS.sleep(2);
            done.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
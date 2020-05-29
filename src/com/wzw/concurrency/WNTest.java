package com.wzw.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WNTest {
    public static void main(String[] args) {
        Test test = new Test();
        WaitTest waitTest = new WaitTest(test);
        NotifyTest notifyTest = new NotifyTest(test);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(notifyTest);
        executorService.execute(waitTest);
        executorService.shutdown();
    }
}

class WaitTest implements Runnable {
    private Test test;
    public WaitTest(Test t) {
        test = t;
    }
    @Override
    public void run() {
        test.f();
    }
}

class NotifyTest implements Runnable {
    private Test test;
    public NotifyTest(Test test) {
        this.test = test;
    }
    @Override
    public void run() {
        test.g();
    }
}

class Test {
    private volatile boolean flag = true;
    public synchronized void f() {
        try {
            TimeUnit.SECONDS.sleep(2);
            notify();
            flag = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void g() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
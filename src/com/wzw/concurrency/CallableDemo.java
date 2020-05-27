package com.wzw.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        List<Future<String>> results = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(new TaskWithResult());
            results.add(future);
        }
        for (Future<String> future : results) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {

            }
        }
        executor.shutdown();
    }
}

class TaskWithResult implements Callable<String> {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String call() throws Exception {

//        Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(new Random(47).nextInt(10));
        return "result of TaskWithResult " + id;
    }
}

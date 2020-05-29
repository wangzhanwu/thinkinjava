package com.wzw.concurrency;

import com.wzw.ios.ProcessFiles;

import java.sql.Time;
import java.util.concurrent.*;

public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new LinkedBlockingDeque();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Producer(queue));
        executor.execute(new Consumer(queue));

        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }
}
class Consumer implements Runnable {
    private BlockingQueue queue;
    public Consumer(BlockingQueue q) {
        queue = q;
    }

    @Override
    public void run() {
        try{
            while (true) {
                Object object = queue.take();
                System.out.println("consume: " + object);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class Producer implements Runnable {
    private BlockingQueue queue;
    private static int count = 0;
    public Producer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try{
            while (true) {
                Thing thing = new Thing();
                System.out.println("produce : " + thing);
                queue.put(thing);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Thing {
    private static int count = 0;
    private final int id = count++;
    public String toString() {
        return "thing-"+id;
    }
}



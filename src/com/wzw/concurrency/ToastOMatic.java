package com.wzw.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                buttererQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Buterer(dryQueue, buttererQueue));
        executorService.execute(new Jammer(buttererQueue, finishedQueue));
        executorService.execute(new Eater(finishedQueue));

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
class Toast{
    public enum Status{DRY, BUTTERED, JAMMED};
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn) {
        id = idn;
    }

    public void butter() {
        status = Status.BUTTERED;
    }
    public void jam() {
        status = Status.JAMMED;
    }
    public Status getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);
    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

class Buterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;
    public Buterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer Interrupt");
        }
        System.out.println("Butterer off");
    }
}

class Jammer implements Runnable {
    private ToastQueue butterQueue, finishedQueue;
    public Jammer(ToastQueue butterQueue, ToastQueue finishedQueue) {
        this.butterQueue = butterQueue;
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butterQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer Interrupt");
        }
        System.out.println("Jammer off");
    }
}

class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int count = 0;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = finishedQueue.take();
                if (toast.getId() != count++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>> Error: " + toast);
                    System.exit(1);
                } else {
                    System.out.println("Wow! " + toast);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupt");
        }
        System.out.println("Eater off");
    }
}

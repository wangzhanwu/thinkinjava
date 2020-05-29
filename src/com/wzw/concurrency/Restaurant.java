package com.wzw.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    Waiter waiter = new Waiter(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waiter);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

}

class Meal {
    private int orderNum;
    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }
    public String toString() {
        return "Meal " + orderNum;
    }
}
class Waiter implements Runnable {
    private Restaurant restaurant;
    public Waiter(Restaurant r) {
        restaurant = r;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                    System.out.println("Waiter got " + restaurant.meal);
                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Waiter interrupted");
            }

        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    int count = 0;
    public Chef(Restaurant r) {
        restaurant = r;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order up! ");
                synchronized (restaurant.waiter) {
                    restaurant.meal =  new Meal(count);
                    restaurant.waiter.notify();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("chef interrupted");
        }
    }
}

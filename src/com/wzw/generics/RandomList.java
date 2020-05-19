package com.wzw.generics;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);
    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> list = new RandomList<>();
        for (String s : "get random element".split(" ")) {
            list.add(s);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.select());
        }
    }
}

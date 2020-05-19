package com.wzw.collectionmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random random  = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Integer t = random.nextInt(20);
            Integer freq = map.get(t);
            map.put(t, freq==null ? 1 : freq+1);
        }
        System.out.println(map);
    }
}

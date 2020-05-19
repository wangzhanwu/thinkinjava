package com.wzw.collectionmap;

import java.util.*;

public class SetOfInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> set = new HashSet<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < 1000; i++) {
            set.add(random.nextInt(30));
        }
        System.out.println(set);
    }
}

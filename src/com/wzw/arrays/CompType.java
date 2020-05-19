package com.wzw.arrays;

import com.wzw.util.Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CompType implements Comparable<CompType> {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "CompType{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(CompType o) {
        return this.id<o.id ? -1 : (this.id==o.id ? 0 : 1);
    }

    public Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType();
            }
        };
    }

    public long getId() {
        return id;
    }
    public static void p(String[] args) {
        CompType ct = new CompType();
        CompType[] array = new CompType[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = ct.generator().next();
        }

        Arrays.sort(array, new CompTypeComparator());
        System.out.println(Arrays.toString(array));
    }
}

class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return o1.getId()<o2.getId() ? -1 : (o1.getId()==o2.getId() ? 0 : 1);
    }


}

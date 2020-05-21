package com.wzw.arrays;

import com.wzw.collectionmap2.CollectionData;
import com.wzw.util.Generator;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 数组生成工具类
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return CollectionData.list(gen, a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return CollectionData.list(gen, size).toArray(a);
    }

    public static void main(String[] args) {
        Integer[] array = array(Integer.class, new RandomGenerator.Integer(), 20);
        System.out.println(Arrays.toString(array));
    }
}

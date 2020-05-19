package com.wzw.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }


    public static <T> T f(Map<String, Integer> map) {
        return null;
    }

    public static <T> List<T> makeList(T... args) {
        List<T> list = new ArrayList<>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(list);
    }
}

package com.wzw.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {

        Class c2 = new ArrayList<String>().getClass();
        Class c3 = new ArrayList<Integer>().getClass();
        System.out.println(c2 == c3);
        System.out.println(Arrays.toString(c2.getTypeParameters()));
        System.out.println(Arrays.toString(c3.getTypeParameters()));

        List<? extends Coffee> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
    }
}

package com.wzw.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TwoTuple<A, B> {
    public final A first;
    public final B second;
    public String temp;
    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Class<?> clazz = ThreeTuple.class;
        Field[] fields = clazz.getFields();
        Method[] methods = clazz.getMethods();
        for (Field f : fields) {
            System.out.println(f.toString());
        }
        System.out.println("---------------------");
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;
    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" + first + ", " + second + ", " + third + "}";
    }
}

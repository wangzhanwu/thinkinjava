package com.wzw.generics;

public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(gm);
        gm.f(1);
        System.out.println("---------------------------");
        gm.g("", 1, 1.0);
    }

    public <T, K, V> void g(T a, K b, V c) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }

    public <T, K> void k(T a, K b, String s) {

    }
}

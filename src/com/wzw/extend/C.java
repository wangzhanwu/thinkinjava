package com.wzw.extend;

import java.util.Random;

public class C {
    public static void main(String[] args) {
        A a = new B(1);
        a.sayClassName();

        B b = new B(1);
        System.out.println(b.i);
        System.out.println(b.j);
    }
}

class RandomGenerator {
    private Random random = new Random(47);
    public A next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new B(3);
            case 1:
                return null;
            case 2:
                return new A(4);

        }
    }
}

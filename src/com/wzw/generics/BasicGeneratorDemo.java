package com.wzw.generics;

import com.wzw.util.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountObject> generator = BasicGenerator.create(CountObject.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());
        }
        System.out.println("_---------------------------------");
        Generator<Coffee> generator1 = new BasicGenerator<>(Coffee.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator1.next());
        }
    }
}

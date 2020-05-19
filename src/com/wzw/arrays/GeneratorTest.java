package com.wzw.arrays;

import com.wzw.util.Generator;

public class GeneratorTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.println(type.getSimpleName() + ":");
            try {
                Generator<?> gen = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(gen.next() + " ");
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        test(RandomGenerator.class);
    }
}

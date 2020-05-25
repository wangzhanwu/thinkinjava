package com.wzw.enums;

import com.wzw.util.Generator;

import java.util.Random;

public class EnumImpl {
    public static <T> void printNext(Generator<T> generator) {
        System.out.println(generator.next());
    }

    public static void main(String[] args) {
        CartoonCharacter c = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(c);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random random = new Random(47);
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

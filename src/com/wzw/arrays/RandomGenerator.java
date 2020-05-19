package com.wzw.arrays;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.wzw.util.Generator;

import java.time.LocalDate;
import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte)random.nextInt();
        }
    }
    public static class Short implements Generator<java.lang.Short> {

        @Override
        public java.lang.Short next() {
            return (short)random.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int mod = 1000;
        public Integer(){}
        public Integer(int mod) {
            this.mod = mod;
        }
        @Override
        public java.lang.Integer next() {
            return random.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private int mod = 1000;
        public Long(){}
        public Long(int mod) {
            this.mod = mod;
        }
        @Override
        public java.lang.Long next() {
            return new java.lang.Long(random.nextInt(mod));
        }
    }

    public static class Float implements Generator<java.lang.Float> {

        @Override
        public java.lang.Float next() {
            int trimmed = Math.round(random.nextFloat() * 100);
            return ((float)trimmed)/100;
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        @Override
        public java.lang.Double next() {
            long trimmed = Math.round(random.nextDouble() * 100);
            return ((double)trimmed)/100;
        }
    }

    static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static class Character implements Generator<java.lang.Character> {

        @Override
        public java.lang.Character next() {
            return chars[random.nextInt(chars.length)];
        }

        public static void main(CountingGenerator.String[] args) {
            CountingGenerator.Character c = new CountingGenerator.Character();
            for (int i = 0; i < 104; i++) {
                System.out.println(c.next());
            }
        }
    }

    public static class String extends CountingGenerator.String {
        {gen = new Character();}
        public String() {}
        public String(int length) {
            super(length);
        }

    }
    public static void main(CountingGenerator.String[] args) {
        float f = 0;
        f++;
        System.out.println(f++);
    }
}

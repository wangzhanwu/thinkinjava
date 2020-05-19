package com.wzw.arrays;

import com.wzw.util.Generator;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            return !value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value = 0;

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }
    public static class Short implements Generator<java.lang.Short> {
        private short value = 0;

        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int value = 0;

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;
        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value = 0;

        @Override
        public java.lang.Float next() {
            return value++;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double value = 0.0;

        @Override
        public java.lang.Double next() {
            return value++;
        }
    }

    static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        private int index = 0;
        @Override
        public java.lang.Character next() {
            return chars[(index++)%chars.length];
        }

        public static void main(String[] args) {
            Character c = new Character();
            for (int i = 0; i < 104; i++) {
                System.out.println(c.next());
            }
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> gen = new Character();
        public String() {}
        public String(int length) {
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = gen.next();
            }
            return new java.lang.String(buf);
        }
    }
    public static void main(String[] args) {
        float f = 0;
        f++;
        System.out.println(f++);
    }
}

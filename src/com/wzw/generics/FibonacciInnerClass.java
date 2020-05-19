package com.wzw.generics;

import java.util.Iterator;

public class FibonacciInnerClass extends Fibonacci {
    private int n;
    public FibonacciInnerClass(int count) {
        n = count;
    }

    private class FiboIterable implements Iterable<Integer> {
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return n > 0;
                }

                @Override
                public Integer next() {
                    return FibonacciInnerClass.this.next();
                }
            };
        }
    }

    public Iterable<Integer> iterator() {
        return new FiboIterable();
    }
}

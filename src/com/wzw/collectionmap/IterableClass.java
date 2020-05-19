package com.wzw.collectionmap;

import java.util.Iterator;
import java.util.Map;

public class IterableClass implements Iterable<String> {
    String[] data = "a b c d e f g h".split(" ");
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < data.length;
            }

            @Override
            public String next() {
                return data[i++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s: new IterableClass()) {
            System.out.println(s);
        }

        for (Map.Entry entry: System.getenv().entrySet()
             ) {

        }
    }
}

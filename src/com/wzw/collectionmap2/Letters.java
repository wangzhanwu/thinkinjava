package com.wzw.collectionmap2;

import com.wzw.util.Generator;

import java.util.*;

public class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 0;
    private char letter = 'A';
    public Letters(){}
    public Letters(int size) {
        this.size = size;
    }

    public Pair<Integer, String> next() {
        return new Pair<>(number++, ""+(letter++));
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }

    public static void main(String[] args) {
        Map<Integer, String> map = MapData.map(new Letters(), 10);
        System.out.println(map);

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        ListIterator<String> ite = list.listIterator();
        System.out.println(list);
        while(ite.hasNext()) {
            ite.add("op");
            String a = ite.next();

        }
        System.out.println(list);
        Integer a = Integer.decode("123");
        System.out.println(a);
        Objects.hashCode("a");
    }
}

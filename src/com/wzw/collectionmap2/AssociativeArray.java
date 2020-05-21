package com.wzw.collectionmap2;

import java.util.HashMap;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if(index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[] {key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (pairs[i][0].equals(key)) {
                return (V)pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(":");
            result.append(pairs[i][1].toString());
            if (i < index)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(10);
        map.put("ocean", "fish");
        map.put("sky", "bird");
        System.out.println(map);


    }
}

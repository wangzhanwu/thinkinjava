package com.wzw.collectionmap2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TypesForSet {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {

        try{
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<SetType>(), SetType.class);
    }
}

class SetType {
    int i;
    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetType setType = (SetType) o;
        return i == setType.i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return i<o.i ? -1 : (i==o.i?0:1);
    }
}

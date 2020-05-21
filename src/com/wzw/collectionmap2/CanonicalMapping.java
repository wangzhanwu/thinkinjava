package com.wzw.collectionmap2;

import java.util.Objects;
import java.util.WeakHashMap;

public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 1000;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key key = new Key(Integer.toString(i));
            Value value = new Value((Integer.toString(i)));
            if (i % 3 == 0) {
                keys[i] = key;
            }
            map.put(key, value);
        }
        System.gc();
    }
}

class Element {
    private String ident;
    public Element(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(ident, element.ident);
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}

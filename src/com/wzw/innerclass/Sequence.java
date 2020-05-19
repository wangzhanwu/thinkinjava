package com.wzw.innerclass;

import java.util.Iterator;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public int add(Object object) {
        if (next < items.length) {
            items[next++] = object;
            return next;
        }
        return -1;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }
        public Object current() {
            return items[i];
        }
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
        public Sequence sequence() {
            return Sequence.this;
        }
    }
    private class SequenceIterator implements Iterator {
        int cursor;
        int lastRet = -1;
        public Object next(){
            int i = cursor;
            cursor = i + 1;
            return items[lastRet=i];
        }
        public boolean hasNext() {
            return cursor != items.length;
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public Iterator iterator() {
        return new SequenceIterator();
    }
    private class SequenceReverseSelector implements Selector {
        private int i = items.length - 1;
        public boolean end() {
            return i == -1;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i>-1) {
                i--;
            }
        }
    }

    public Selector reverseSelector() {
        return new SequenceReverseSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current());
            selector.next();
        }
        System.out.println();
        Selector reverseSelector = sequence.reverseSelector();
        while(!reverseSelector.end()) {
            System.out.print(reverseSelector.current());
            reverseSelector.next();
        }

        System.out.println();
        Iterator iterator = sequence.iterator();
        while(iterator.hasNext()) {
            Object o = iterator.next();
            System.out.print(o);
        }
    }
}

interface Selector{
    boolean end();
    Object current();
    void next();
}

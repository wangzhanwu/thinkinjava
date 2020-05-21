package com.wzw.collectionmap2;

import java.util.Iterator;

public class SList<T> {
    private static class Link<U> {
        U item;
        Link<U> next;
        public Link() {
            this.next = null;
            this.item = null;
        }
        public Link(Link<U> next, U item) {
            this.next = next;
            this.item = item;
        }
        public boolean end() {
            return item == null && next == null;
        }
    }
    private static class SListIterator<E> implements Iterator<E> {
        private Link<E> top = new Link<>();
        @Override
        public E next() {
            E e = top.item;
            top = top.next;
            return e;
        }

        @Override
        public boolean hasNext() {
            return top.end();
        }

        public void push(E e) {
            top = new Link<>(top, e);
        }

        public boolean remove(E e) {
            E t = next();
            if (e.equals(t)) {

            }
            return false;
        }
    }



}

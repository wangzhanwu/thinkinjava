package com.wzw.generics;

import sun.rmi.transport.proxy.RMISocketInfo;

public class LinkedStack2<T> {
    private class Node<T> {
        private T item;
        private Node<T> next;
        public Node() {
            item = null;
            next = null;
        }
        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
        public boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();//哨兵
    public void push(T item) {
        top = new Node<>(item, top);
    }
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack2<String> stack = new LinkedStack2<>();
        for (String s : "abcdefghijklmnopqrstuvwxyz".split("")) {
            stack.push(s);
        }
        String s;
        while((s=stack.pop()) != null) {
            System.out.println(s);
        }
    }
}

package com.wzw.generics;

public class ArrayStack<T> {
    private int size;
    private Object[] array;
    public ArrayStack(int size) {
        this.size = size;
        array = new Object[size];
    }

    private int index = 0;

    public void push(T item) {
        array[index++] = item;
    }

    public T pop() {
        return (T)array[index--];
    }
    public boolean end() {
        return index < 0;
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>(30);
        for (String s : "abcdefghijklmnopqrstuvwxyz".split("")) {
            arrayStack.push(s);
        }
        String s;
        while(!arrayStack.end()) {
            System.out.println(arrayStack.pop());
        }
    }
}

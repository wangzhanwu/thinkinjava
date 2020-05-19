package com.wzw.extend;

public class B extends A {

    int j;
    public B(int j) {
        super(2);
        this.j = j;
    }
    @Override
    public void check() {
        System.out.println("B");
    }
}

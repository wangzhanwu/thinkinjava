package com.wzw.innerclass;

public class MineImpl implements Mine {
    public void print() {
        System.out.println("good weather");
    }

    public static void main(String[] args) {
        MineImpl m =  new MineImpl();
        W.f(m);
    }
}

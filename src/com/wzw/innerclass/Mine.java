package com.wzw.innerclass;

public interface Mine {
    void print();
    class W{
        public static void f(Mine m) {
            m.print();
        }
    }
}

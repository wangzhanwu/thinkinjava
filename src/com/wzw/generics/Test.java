package com.wzw.generics;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        TestImpl ts = new TestImpl();
        ts.k(ts);

        Class a = new ArrayList<String>().getClass();
        Class b = new ArrayList<Integer>().getClass();
        System.out.println(a == b);
    }


}

interface TestI {
    void f();
    void g();
}

class TestImpl implements TestI {
    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void g() {
        System.out.println("g()");
    }

    public <T extends TestI> void k(T t) {
        t.f();
        t.g();
    }
}
class List2<T> extends ArrayList<T> {

}

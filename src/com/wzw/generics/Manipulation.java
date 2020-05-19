package com.wzw.generics;

import java.util.Arrays;

public class Manipulation {


    public static void main(String[] args) {
        Manipulator<HasF> m = new Manipulator<>(new HasF());
        m.manipulate();
        System.out.println(Arrays.toString(m.getClass().getTypeParameters()));

        Manipulator<HasFChild> m2 = new Manipulator<>(new HasFChild());
        HasFChild h = m2.get();

    }
}

class HasF{
    public void f() {
        System.out.println("HasF.f()");
    }
}
class HasFChild extends HasF{}

class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x) {
        this.obj = x;
    }
    public void manipulate() {
        obj.f();
    }
    public T get() {
        return obj;
    }
}

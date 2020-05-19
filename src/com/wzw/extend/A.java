package com.wzw.extend;

import java.lang.reflect.Field;

public class A {
    public int i;

    public A(int i) {
        this.i = i;
    }
    public void check() {
        System.out.println("A");
    }

    public void sayClassName() {
        check();
    }

    public static void main(String[] args) {
        E e = new E();
        F f = new F();

        E e1 = new F();
        System.out.println(F.class.isInstance(f));
        System.out.println(E.class.isInstance(f));

        System.out.println(F.class.isInstance(e1));
    }

    private static void print(Class cc) {

        System.out.println(cc.getName());
        Field[] fields = cc.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("----------------");
        Class clazz = cc.getSuperclass();

        if (clazz !=null) {
            System.out.println(clazz.getSimpleName());
            print(clazz);
        }
    }
}

abstract class D {
    int i;
    D(){}
    D(int i){
        this.i = i;
        System.out.println("D i="+i);
        print();
    }
    abstract void print();
}

class E extends D{
    int j;
    E(){}
    E(int j) {
        super(j+1);
        this.j = j;
        System.out.println("E j="+j);
    }

    @Override
    void print() {
        System.out.println("j="+j);
    }
}

class F extends E {

}

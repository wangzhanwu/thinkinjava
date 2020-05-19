package com.wzw.exceptions;

import com.sun.javafx.binding.StringFormatter;

public class Test extends B{
    @Override
    public void f() throws MyNException3 {

    }

    public static void main(String[] args) {
        A a = new Test();
        try {
            a.f();
        } catch (MyNException1 myNException1) {
            myNException1.printStackTrace();
        }
        a.g();
        String n = new String("sdfs");
    }
}

class A {
    public void f() throws MyNException1 {

    }
    public void g() throws RuntimeException{

    }
}

class B extends A {
    @Override
    public void f() throws MyNException2 {

    }
}
class MyNException1 extends  Exception {

}
class MyNException2 extends MyNException1 {

}

class MyNException3 extends MyNException2 {

}

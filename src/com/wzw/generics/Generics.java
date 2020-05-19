package com.wzw.generics;

import sun.net.www.content.text.Generic;

public class Generics {
    public static void main(String[] args) {
        Generic1<? super Coffee> generic1 = new Generic1<>();
        generic1.f(new Mocha());

        Generic2<? extends Coffee> generic2 = new Generic2<>();
        generic2.g();
    }

}

class Generic1<T> {
    public void f(T t) {

    }
}

class Generic2<T> {
    public T g() {
        return null;
    }
}

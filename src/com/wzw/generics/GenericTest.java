package com.wzw.generics;

import java.util.List;

public class GenericTest {
}
class Generic11<T> {
    public void f(T t) {

    }

    public <T> void f(List<? extends T> list) {
        
    }
}

class Generic22<T> {
    public T f() {
        return null;
    }
}

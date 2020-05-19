package com.wzw.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

    public static <T> void write(List<? super T> list , T item) {
        list.add(item);
    }

    public static void main(String[] args) {
        List<Coffee> list = new ArrayList<>();
        write(list, new Coffee());
        write(list, new Mocha());
    }
}

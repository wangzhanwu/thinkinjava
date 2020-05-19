package com.wzw.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T> List<T> makList(T... args) {
        List<T> result = new ArrayList<>();
        for (T t : args) {
            result.add(t);
        }
        return result;
    }
}

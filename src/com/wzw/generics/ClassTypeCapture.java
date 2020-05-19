package com.wzw.generics;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> map = new HashMap<>();
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object args) {
        return kind.isInstance(args);
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public void creatNew(String typeName) {
        addType(typeName, typeName.getClass());
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctc = new ClassTypeCapture<>(Building.class);
        System.out.println(ctc.f(new Building()));
        System.out.println(ctc.f(new House()));

        ctc.creatNew("abc");
        System.out.println(ctc.map);
    }


}

class Building {

}
class House extends Building {

}

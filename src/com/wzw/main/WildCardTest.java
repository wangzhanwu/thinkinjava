package com.wzw.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WildCardTest {
    Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
        /*Iterator<String> iterator = list.listIterator();
        while(iterator.hasNext()) {
            String item = iterator.next();
            if("1".equals(item)) {
                iterator.remove();
            }
        }*/

//        for (String item: list) {
//            if("a".equals(item)) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list.toString());

        Object[] obj = new String[]{"1"};
        System.out.println(obj.getClass());
    }
}

class Fruit {}
class Apple extends Fruit {}
class Plate<T> {
    T item;
    public Plate(T t) {
        item = t;
    }
    public void set(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}

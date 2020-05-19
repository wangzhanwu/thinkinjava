package com.wzw.collectionmap;

import java.util.*;

public class CrossContainerIteration {
    public static void display(Iterator<String> iterator) {
        while(iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
            iterator.remove();
        }
    }
    public static void display(ListIterator<String> listIterator) {
        while(listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex());
            System.out.println(listIterator.previousIndex());
            System.out.println(listIterator.next());
        }
        System.out.println("================");
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        Iterator<String> iterator = list.iterator();
        display(iterator);
        System.out.println(list.size());

        display();
    }

    public static void display() {
        List<Integer> list1 = new ArrayList<>(10);
        List<Integer> list2 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        ListIterator<Integer> iterator = list1.listIterator(list1.size());
        while(iterator.hasPrevious()) {
            Integer i = iterator.previous();
            list2.add(i);
        }
        System.out.println(list1);
        System.out.println(list2);
        List list = new LinkedList();
    }
}

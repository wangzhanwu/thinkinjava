package com.wzw.generics;

import com.wzw.extend.A;
import com.wzw.util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store extends ArrayList<Aisle> {
    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
        Number[] array = new Integer[10];
        List<? extends Number> list = new ArrayList<Integer>();
//        list.add(new Integer(0));
    }
}


class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}
class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}
class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String toString() {
        return id + " : " + description + ", price: $" + price;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        Random random = new Random(47);
        @Override
        public Product next() {
            return new Product(random.nextInt(1000), "Test", random.nextDouble() * 1000.0 + 0.99);
        }
    };
}

package com.wzw.generics;

import com.wzw.util.Generator;

public class Customer {
    private static long counter = 0;
    private final long id = counter++;
    private Customer() {}
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }

    public static void main(String[] args) {
        Generator<Customer> generator = Customer.generator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());

        }
    }
}

class Teller {
    private static long counter = 0;
    private final long id = counter++;
    private Teller(){}

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}
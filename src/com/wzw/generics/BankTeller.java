package com.wzw.generics;

import com.wzw.util.Generator;

import java.util.*;

public class BankTeller {
    public static void server(Teller t, Customer c) {
        System.out.println(t + " server " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> customers = new LinkedList<>();
        Generators.fill(customers, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator(), 4);
        for (Customer c : customers) {
            server(tellers.get(random.nextInt(tellers.size())), c);
        }
    }
}

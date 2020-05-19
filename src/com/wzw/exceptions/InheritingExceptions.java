package com.wzw.exceptions;

public class InheritingExceptions {
    public static void f() throws SimpleException {
        System.out.println("Throws SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (SimpleException e) {
            System.out.println("Caught it");
            e.printStackTrace(System.err);
        }
    }
}

class SimpleException extends Exception {}

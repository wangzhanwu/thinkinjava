package com.wzw.exceptions;

public class FullConstructors {
    public static void main(String[] args) {
        try{
            throw new Exception("abc");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("qqqwwq");
        }
    }
}

class MyException extends Exception {
    public MyException(){}
    public MyException(String msg) {
        super(msg);
    }
}
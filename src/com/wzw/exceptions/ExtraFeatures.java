package com.wzw.exceptions;

public class ExtraFeatures {
}

class MyException2 extends Exception {
    private int x;

    public MyException2() {

    }

    public MyException2(String msg) {
        super(msg);
    }
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public MyException2(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MyException2(Throwable cause) {
        super(cause);
    }

    public int val() {
        return x;
    }

    public String getMessage() {
        return "Detail message:"+x + " " +super.getMessage();
    }
}

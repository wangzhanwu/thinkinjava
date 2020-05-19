package com.wzw.innerclass;

public class Outer {

    private String content;
    public Outer(String s) {
        this.content = s;
    }
    class Inner {
        public String toString() {
            return content;
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("didadidadi");
        Outer.Inner inner = outer.getInner();
        System.out.println(inner);
    }
}

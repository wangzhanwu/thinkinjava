package com.wzw.innerclass;

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    class Inner{
        public DotThis getOuter() {
            return DotThis.this;
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.getInner();
        dti.getOuter().f();
    }
}

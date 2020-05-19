package com.wzw.main;

public class Tank
{
    Boolean checkFull = false;

    public Tank(Boolean checkFull) {
        this.checkFull = checkFull;
    }

    public void checkEmpty() {
        checkFull = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkFull) {
            super.finalize();
            System.out.println("not empty");
        }

    }

    public static void main(String[] args) {
        Tank tank = new Tank(true);
        tank.checkEmpty();
        new Tank(true);
        System.gc();
        Tank2.main(new String[]{"a", "b", "c"});
    }
}
class Tank2 {

    public static void f() {

    }
    public static void main(String[] args) {
        for (String str : args) {
            System.out.println(str);
        }
    }
}

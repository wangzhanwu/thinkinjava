package com.wzw.classtype;

import java.util.Calendar;

public class Pets {
    public static class Pet {}

    public static class Dog extends Pet {}
    public static class Mutt extends Dog{}
    public static class Pug extends Dog {}

    public static class Cat extends Pet {}
    public static class EgyptianMau extends Cat {}
    public static class Manx extends Cat {}
    public static class Cymrix extends Manx {}

    public static class Rodent extends Pet {}
    public static class Rat extends Rodent{}
    public static class Mouse extends Rodent{}
    public static class Hamster extends Rodent{}
}

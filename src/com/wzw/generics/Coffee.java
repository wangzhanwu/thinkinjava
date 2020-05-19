package com.wzw.generics;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id + "原味";
    }

    public static void main(String[] args) {
        SugarCoffee sc = new SugarCoffee(new Coffee());
        MilkeCoffee mc = new MilkeCoffee(sc);
        System.out.println(mc);
    }
}

class Latte extends Coffee{}
class Mocha extends Coffee{}
class Cappuccino extends Coffee{}
class Americano extends Coffee{}
class Breve extends Coffee{}

class CoffeeDecorator extends Coffee{
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class SugarCoffee extends CoffeeDecorator {
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String toString() {
        return super.toString() + "加糖";
    }
}

class MilkeCoffee extends CoffeeDecorator {
    public MilkeCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String toString() {
        return super.toString() + "加牛奶";
    }
}
package com.wzw.dp;

public class Decorator {

    public static void main(String[] args) {
        SimplePerson simplePerson = new SimplePerson("wzw");
        FlyPerson flyPerson = new FlyPerson(simplePerson);
        SwimPerson swimPerson = new SwimPerson(flyPerson);
        swimPerson.show();
    }
}

abstract class Person {
    public abstract void show();
}

class SimplePerson extends Person {
    private String name;

    public SimplePerson(){}

    public SimplePerson(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.printf("%s是简简单单的一个人", name);
    }
}

abstract class PersonDecorator extends Person {
    private Person person;
    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        person.show();
    }
}

class FlyPerson extends PersonDecorator {
    public FlyPerson(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        System.out.print(",ta会玩滑翔");
    }
}

class SwimPerson extends PersonDecorator {
    public SwimPerson(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        System.out.print(",ta会游泳");
    }
}

package com.wzw.extend;

import static com.wzw.util.Print.*;
public class Detergent extends Cleanser{

    public Detergent() {
        print("Detergent Construct");
    }
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        print(detergent);

        Cleanser.main(args);
    }
}

class Cleanser {
    private String s = "Cleanser";

    public Cleanser() {
        print("Cleanser Construct");
    }

    public void append(String a) {
        s += a;
    }
    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();cleanser.apply();cleanser.scrub();
        print(cleanser);
    }
}

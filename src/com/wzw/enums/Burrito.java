package com.wzw.enums;

import static com.wzw.enums.Spiciness.*;
public class Burrito {
    private Spiciness degree;
    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(MILD));
        System.out.println(new Burrito(MEDIUM));
    }
}

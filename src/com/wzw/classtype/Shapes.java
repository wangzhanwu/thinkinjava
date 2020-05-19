package com.wzw.classtype;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> list = Arrays.asList(new Circle(), new Square());
        for (Shape shape : list) {
            shape.draw();
        }
    }
}

abstract class Shape{
    void draw() {
        System.out.println(this + ".draw()");
    }
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}
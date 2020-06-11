package com.wzw.dp;

public class SimpleFactory {

    public static void main(String[] args) {
        Operation operation = createOperation("+");
        operation.number1 = 1.0;
        operation.number2 = 2.0;
        System.out.println(operation.calculate());
    }
    public static Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Subtract();
                break;
            case "*":
                operation = new Multiply();
                break;
            case "/":
                operation = new Divide();
                break;
            default:
        }
        return operation;
    }
}

abstract class Operation {
    protected double number1;
    protected double number2;

    public abstract double calculate();
}

class Add extends Operation {

    @Override
    public double calculate() {
        return number1 + number2;
    }
}

class Subtract extends Operation {

    @Override
    public double calculate() {
        return number1 - number2;
    }
}

class Multiply extends Operation {
    @Override
    public double calculate() {
        return number1 * number2;
    }
}

class Divide extends Operation {
    @Override
    public double calculate() {
        if (number2 == 0) throw new RuntimeException("除数不能为零");
        return number1 / number2;
    }
}

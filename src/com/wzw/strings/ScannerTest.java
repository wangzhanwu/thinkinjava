package com.wzw.strings;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

    }

    private void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println(age);
    }
}

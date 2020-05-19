package com.wzw.classtype;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowMethods {

    public ShowMethods(String name) {
        System.out.println("constructor args : "+name);
    }
    static Pattern pattern = Pattern.compile("\\w+\\.");
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = ShowMethods.class.getMethods();
        Constructor[] constructors = ShowMethods.class.getConstructors();
        for (Method method : methods) {
            System.out.println(pattern.matcher(method.toString()).replaceAll(""));
        }
        System.out.println("----------------------------");
        for (Constructor constructor : constructors) {
            System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
            System.out.println(constructor.newInstance("sat"));
        }
    }

    public String toString() {
        return "ShowMethods";
    }
}

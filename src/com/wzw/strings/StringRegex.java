package com.wzw.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegex {
    public static void main(String[] args) {
        String regex = "\\w+";
        String cs = "As long as there is injustice, whenever";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cs);

        while(matcher.find()) {
            System.out.printf("%s %d %d\n", matcher.group(), matcher.start(), matcher.end());
//            System.out.println(matcher.matches());
//            System.out.println(matcher.lookingAt());;
        }
        System.out.println("----------------------------------");
        test1();

    }

    public static void special() {
        String str  = "abcdefg&h$fd#$%gdffs()";
        String regex = "[^\\w]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.printf("%-5s %02d %02d\n", matcher.group(), matcher.start(), matcher.end());
        }
    }

    public static void test() {
        String str  = "I am dancing and singing";
        String regex = "\\w+(?=ing\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.printf("%-5s %02d %02d\n", matcher.group(), matcher.start(), matcher.end());
        }
    }
    public static void test1() {
        String str  = "I am dancing and singing";
        String regex = "(?<=\\bdan)\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.printf("%-5s %02d %02d\n", matcher.group(), matcher.start(), matcher.end());
        }
    }
}

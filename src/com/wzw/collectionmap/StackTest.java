package com.wzw.collectionmap;

import java.util.HashMap;
import java.util.Map;

public class StackTest {
    private static String s = "+U+n+c---+e+r+t---+s-+i-+n+t+y---+-+r+u--+l+e+s---";
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length;) {
            switch (array[i++]) {
                case '+':
                    stack.push(array[i++]);
                    break;
                case '-':
                    System.out.print(stack.pop());
                    break;
            }
        }
        Map map = new HashMap();

    }
}

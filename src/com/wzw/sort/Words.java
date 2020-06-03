package com.wzw.sort;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> wordList = loadList();

    private List<String> loadList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        return list;
    }

    Object execute(CallBackInterface<String> callBackInterface) {
        return callBackInterface.process(wordList);
    }

    public static void main(String[] args) {
        new Words().execute(new CallBackInterface<String>() {
            @Override
            public String process(List<String> param) {
                return null;
            }
        });
    }
}

interface CallBackInterface<T> {
    T process(List<T> param);
}

class WordTest implements CallBackInterface<String> {
    @Override
    public String process(List<String> param) {
        System.out.println("do something");
        System.out.println(param);
        return null;
    }

    public static void main(String[] args) {
        Words words = new Words();
        WordTest wordTest = new WordTest();
        words.execute(wordTest);
    }
}

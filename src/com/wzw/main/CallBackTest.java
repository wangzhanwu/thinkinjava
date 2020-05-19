package com.wzw.main;

import java.util.ArrayList;
import java.util.List;

public class CallBackTest {
    public static void main(String[] args) {
        A a = new A();
        a.execute(new CallBackInterface() {
            @Override
            public Object process(List param) {
                param = a.wordList;
                for (int i = 0; i < param.size(); i++) {
                    param.remove("1");
                }
                return null;
            }
        });
    }
}

interface CallBackInterface<T> {
    T process(List<Object> param);
}

class A {
    public List<String> wordList = loadList();

    private List<String> loadList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    public <T> T execute(CallBackInterface callBackInterface) {
        return (T)callBackInterface.process(wordList);
    }
}

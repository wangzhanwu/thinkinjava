package com.wzw.classtype;

import java.util.ArrayList;
import java.util.List;

public class FillList<T> {
    private Class<T> type;
    public FillList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> list = new ArrayList<>(nElements);
        try {
            for (int i = 0; i < nElements; i++) {
                list.add(type.newInstance());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        FillList<CountedInteger> fillList = new FillList<>(CountedInteger.class);
        System.out.println(fillList.create(10));
    }
}

class CountedInteger {
  private static long counter;
  private final long id = counter++;
  public String toString() {
      return Long.toString(id);
  }
}

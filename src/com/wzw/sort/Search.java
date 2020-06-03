package com.wzw.sort;

public class Search {

    public static int sequentialSearch(int[] array, int key) {
        if (array[0] == key) {
            return 0;
        }
        array[0] = key;
        int i = array.length - 1;
        while (array[i] != key) {
            i--;
        }
        return i==0 ? -1 : i;
    }
}

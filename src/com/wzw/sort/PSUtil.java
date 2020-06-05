package com.wzw.sort;

import java.util.Arrays;

public class PSUtil {
    public static void swap(int[] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}

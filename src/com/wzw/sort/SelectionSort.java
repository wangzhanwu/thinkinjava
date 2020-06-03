package com.wzw.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {12,24,23,10,67,45,56};
        print(array);
        print(sort0(array));
    }

    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        int min = 0;
        for (int i = 0; i < arrayCopy.length; i++) {
            min = i;
            for (int j = i+1; j < arrayCopy.length; j++) {
                if (arrayCopy[min] > arrayCopy[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arrayCopy, i, min);
            }
        }
        return arrayCopy;
    }


    /*================工具方法==============*/
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}

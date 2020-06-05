package com.wzw.sort;

import java.util.Arrays;

/**
 * 直接插入排序 O(n2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2};
        PSUtil.print(sort0(array));
    }

    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 1; i < arrayCopy.length; i++) {
            if (arrayCopy[i] < arrayCopy[i-1]) {
                int sentinel = arrayCopy[i];
                int j;
                for (j = i-1; j>=0 && arrayCopy[j]>sentinel; j--) {
                    arrayCopy[j + 1] = arrayCopy[j];
                }
                arrayCopy[j+1] = sentinel;
            }
        }

        return arrayCopy;
    }
}

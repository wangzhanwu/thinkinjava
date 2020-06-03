package com.wzw.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private static int[] array = {2,1,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        print(array);
        print(sort2(array));

    }

    public static int[] sort2(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        boolean flag = true;
        for (int i = 0; i < arrayCopy.length && flag; i++) {
            flag = false;
            for (int j = arrayCopy.length-2; j >= i ; j--) {
                if (arrayCopy[j] > arrayCopy[j+1]) {
                    swap(arrayCopy, j, j + 1);
                    flag = true;
                }
            }
        }
        return arrayCopy;
    }

    /**
     * 真正的冒泡排序
     * @param array
     * @return
     */
    public static int[] sort1(int[] array) {
        int count = 0;
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arrayCopy.length; i++) {
            for (int j = arrayCopy.length-2; j >=i ; j--) {
                if (arrayCopy[j] > arrayCopy[j+1]) {
                    swap(arrayCopy, j, j+1);
                }
            }
        }
        return arrayCopy;
    }

    /**
     * 冒泡最容易想到的实现
     * @param array
     * @return
     */
    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arrayCopy.length-1; i++) {
            for (int j = i + 1; j < arrayCopy.length; j++) {
                if (arrayCopy[i] > arrayCopy[j]) {
                    swap(arrayCopy, i, j);
                }
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

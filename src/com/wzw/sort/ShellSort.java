package com.wzw.sort;

import java.util.Arrays;

/**
 * 希尔排序 O(n3/2) 不稳定
 * 希尔排序将相隔某个增量的记录组成的一个子序列，进行跳跃式的移动，是的排序的效率提高。
 * 最后一轮当increment=1时，其实就是一个直接插入排序，因为整个序列已经是基本有序，所以移动的次数较少。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {9, 6, 7, 4, 5, 3, 8, 1, 2};
        print(sort0(array));
    }
    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        int increment = arrayCopy.length;
        do {
            increment = increment/3 + 1;
            for (int i = increment; i < arrayCopy.length; i+=1) {
                if (arrayCopy[i] < arrayCopy[i-increment]) {
                    int sentinel = arrayCopy[i];
                    int j;
                    for (j = i-increment; j>=0 && arrayCopy[j] > sentinel ; j-=increment) {
                        arrayCopy[j+increment] = arrayCopy[j];
                    }
                    arrayCopy[j+increment] = sentinel;
                }
            }
        } while (increment > 1);
        return arrayCopy;
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}

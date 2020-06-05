package com.wzw.sort;

import java.util.Arrays;
import static com.wzw.sort.PSUtil.*;

/**
 * 堆排序 时间复杂度O(nlogn) 不稳定
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        print(sort0(array));
    }

    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = arrayCopy.length/2-1; i >= 0; i--) {
            headAdjust(arrayCopy, i, arrayCopy.length);
        }
        for (int i = arrayCopy.length-1; i > 0; i--) {
            swap(arrayCopy, 0, i);
            headAdjust(arrayCopy, 0, i);
        }
        return  arrayCopy;
    }
    /**
     * 将一个序列调整为一个大顶堆
     * @param array
     * @param s 分支节点
     * @param m 序列长度：每次都是变化的-1
     */
    private static void headAdjust(int[] array, int s, int m) {
        int temp = array[s];
        for (int i = 2*s+1; i < m; i=2*i+1) {
            if (i + 1 < m && array[i] < array[i+1]) {
                ++i;
            }
            if (temp >= array[i]) {
                break;
            }
            array[s] = array[i];
            s = i;
        }
        array[s] = temp;
    }


}

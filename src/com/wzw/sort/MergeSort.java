package com.wzw.sort;

import java.util.Arrays;

import static com.wzw.sort.PSUtil.*;

/**
 * 归并排序 O(nlogn) 稳定
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {2,5,7,9,1,3,4,6,8};
        print(sort0(array));
    }

    /**
     * 递归实现归并排序
     * @param array
     * @return
     */
    public static int[] sort0(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        mSort(arrayCopy, arrayCopy, 0, arrayCopy.length-1);
        return arrayCopy;
    }

    /**
     * 非递归实现归并排序
     * @param array
     * @return
     */
    public static int[] sort1(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);

        return arrayCopy;
    }


    private static void mSort(int[] sr, int[] tr1, int s, int t) {
        int m;
        int[] tr2 = new int[sr.length];
        if (s==t) {
            tr1[s] = sr[s];
        } else {
            m = (s+t)/2;//将sr[s...t]分为sr[s...m]和sr[m+1...t]
            mSort(sr, tr2, s, m);//递归将sr[s...m]归并为tr2[s...m]
            mSort(sr, tr2, m+1, t);//递归将sr[m+1...t]归并为tr2[m+1...t]
            merge(tr2, tr1, s, m, t);//将tr2[s...m]和tr2[m+1...t]归并到tr1[s...t]
        }
    }
    /**
     * 将有序的sr[i...m]和sr[m+1...n]归并为有序的tr[i...n]
     * @param sr
     * @param tr
     * @param i
     * @param m
     * @param n
     */
    private static void merge(int[] sr, int[] tr, int i, int m, int n) {
        int j, k, l;
        for (j = m+1, k=i; i<=m && j<=n; k++) {
            if (sr[i] < sr[j]) {
                tr[k] = sr[i++];
            } else {
                tr[k] = sr[j++];
            }
        }

        if (i<=m) {
            for (l = 0; l <= m-i ; l++) {
                tr[k + l] = sr[i + l];
            }
        }
        if (j<=n) {
            for (l = 0; l <= n-j; l++) {
                tr[k+l] = sr[j+l];
            }
        }
    }
}

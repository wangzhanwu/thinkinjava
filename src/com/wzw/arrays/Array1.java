package com.wzw.arrays;

import java.util.Arrays;
import java.util.Random;

public class Array1 {

    public static void main(String[] args) {
        int[][] a = new int[2][3];
        int[][][] b = new int[2][2][];
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));

        int[] c = new int[10];
        Arrays.fill(c, 10);
        System.out.println(Arrays.toString(c));
    }
}

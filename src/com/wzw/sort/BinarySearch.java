package com.wzw.sort;

public class BinarySearch {

    public static int search(int[] array, int key) {
        int low = 0, mid = 0, high = array.length - 1;
        while (low <= high) {
//            mid = (low + high) / 2;
            mid = low + (high - low) * (key - array[low]) / (array[high] - array[low]); //插值查找
            System.out.printf("low=%d, mid=%d, high=%d\n", low, mid, high);
            if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 12, 13, 45, 67, 89, 100};
        System.out.println(search(array, 45));
    }
}

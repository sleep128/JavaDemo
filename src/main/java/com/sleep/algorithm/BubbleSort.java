package com.sleep.algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 1, 4, 2, 6, 5, 7, 9, 8};
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println("----");
        sort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 冒泡排序
     * @param data
     */
    public static void sort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j + 1] < data[j]) {
                    int index = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = index;
                }
            }
        }

    }
}

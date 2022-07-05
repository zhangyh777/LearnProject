package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class SHELL {
    public static void main(String[] args) {
        int[] array = {7, 5, 1, 3, 4, 0};
        sh(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sh(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i - gap;
                int insertVal = array[i];
                while (j >= 0 && insertVal < array[j]) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = insertVal;
            }
        }

//        int l = array.length;
//        //第一轮
//        for (int i = 3; i < l; i++) {
//            int insertVal = array[i];
//            for (int j = i - 3; j >= 0; j -= 3) {
//                if (array[j] > insertVal) {
//                    array[j+3] = array[j];
//                    array[j] = insertVal;
//                }
//            }
//        }
//        //第二轮
//        for (int i = 1; i < l; i++) {
//            int insertVal = array[i];
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (array[j] > insertVal) {
//                    array[j + 1] = array[j];
//                    array[j] = insertVal;
//
//                }
//            }
//        }
    }
}

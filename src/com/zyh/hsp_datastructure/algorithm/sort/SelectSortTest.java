package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSortTest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1, 6, 0};
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        System.out.println("排序后的数组为：");
        System.out.println(Arrays.toString(arr));


    }

    public static void selectSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length-1; i++) {
            //假设每次参与排序的部分,第一个为最小值
            minIndex = i;
            //将后面的数和设定的最小值相比较，找出实际最小值，记下索引，array[index]就是该轮排序最小值
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex!=i){//如果最小值不在第一个位置才需要进行顺序交换，
                            //否则（最小值就是第一个数字）不用交换
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                System.out.println(Arrays.toString(array));
            }
        }
    }
}


//        //第一轮
//        int minIndex = 0;
//        int min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (min > array[i]) {//交换位置
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        array[minIndex] = array[0];
//        array[0] = min;
//
//        //第二轮
//        minIndex = 1;
//        min = array[1];
//        for (int i = 2; i < array.length; i++) {
//            if (min > array[i]) {
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        array[minIndex] = array[1];
//        array[1] = min;

//        //第三轮
//        minIndex = 2;
//        min = array[2];
//        for (int i = 3; i < array.length; i++) {
//            if (min > array[i]) {//交换位置
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        array[minIndex] = array[2];
//        array[2] = min;

//        //第四轮
//        minIndex = 3;
//        min = array[3];
//        for (int i = 4; i < array.length; i++) {
//            if (min > array[i]) {//交换位置
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        array[minIndex] = array[3];
//        array[3] = min;

//        //第五轮
//        minIndex = 4;
//        min = array[4];
//        for (int i = 5; i < array.length; i++) {
//            if (min > array[i]) {//交换位置
//                min = array[i];
//                minIndex = i;
//            }
//        }
//        array[minIndex] = array[4];
//        array[4] = min;


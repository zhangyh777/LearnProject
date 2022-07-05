package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序（也是插入排序，但进行了增量递减分组优化）
 * 把数据按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的数据越来越多，
 * 当增量减至1时，整个数组被看作一组，算法便终止。
 */
public class ShellSortTest {
    public static void main(String[] args) {
        int[] array1 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] array2 = new int[10000];

//        long start = System.currentTimeMillis();
        shellSort2(array1);
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
        System.out.println(Arrays.toString(array1));

    }

    //交换法希尔排序
    public static void shellSort1(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {//增量递减,第一次增量为gap=length/2,递减：gap/=2
            for (int i = gap; i < array.length; i++) {
                //相距为gap的数为一组,i-gap-gap...,..i-gap,i
                for (int j = i - gap; j >= 0; j -= gap) {//交换法
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        //交换，两步赋值操作
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
//        //索引增量递减
//        //第一次根据索引增量分组，增量gap=length/2
//        for (int i = array.length/2; i < array.length; i++) {//
//            for (int j = i - 5; j >= 0; j -= 5) {//
//                if (array[j] > array[j + 5]) {
//                    int temp = array[j];
//                    array[j] = array[j + 5];
//                    array[j + 5] = temp;
//                }
//            }
//        }
//        //增量递减
//        //第二次根据索引增量分组，增量gap=gap/2
//        for (int i = array.length/2/2; i < array.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (array[j] > array[j + 2]) {
//                    int temp = array[j];
//                    array[j] = array[j + 2];
//                    array[j + 2] = temp;
//                }
//            }
//        }
//        //第三次
//        for (int i = array.length/2/2/2; i < array.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }
    }

    //移位法希尔排序
    public static void shellSort2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {//增量递减,第一次增量为gap=length/2,递减：gap/=2
            for (int i = gap; i < array.length; i++) {
                //相距为gap的数为一组,i-gap-gap...,..i-gap,i
                //做直接插入排序
                int temp = array[i];//待插入元素
                int j = i - gap;
                while (j >= 0 && temp < array[j]) {
                    array[j + gap] = array[j];//大的数字后移
                    j -= gap;
                }
                array[j + gap] = temp;
            }
        }
    }
}

package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 1, 6, 0};
        long start = System.currentTimeMillis();
        bubble(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 优化：当某一轮排序时数据并没有发生变化，说明冒泡排序已经结束，可以直接跳出
     */
    public static void bubble(int[] array) {
        boolean flag = false;//排序标志
        for (int i = 0; i < array.length - 1; i++) {//N个数冒泡排序,要排N-1轮
            for (int j = 0; j < array.length - 1 - i; j++) {//第n轮进行N-n次排序
                if (array[j] > array[j + 1]) {//前面的数比后面的数大，要进行排序
                    flag = true;//排序标志
                    //排序操作，小的在前，大的在后
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flag == false) {//排序没有发生的话，跳出循环
                break;
            } else {
                flag = false;
            }
            System.out.printf("第%d轮排序结果为：", i + 1);
            System.out.println(Arrays.toString(array));
        }
    }



}




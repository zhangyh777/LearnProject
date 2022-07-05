package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 6, 4, 5};
        System.out.println(Arrays.toString(InsertSort(array)));
    }

    public static int[] InsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {//第一个元素看作是一个有序序列，从第二个元素开始插入，直到数组元素都插完
            int insertVal = array[i];//待插入元素为array[i],那么需要和索引为i-1的有序元素比较
            int insertindex = i - 1;
            //待插入的数据比待插入索引处的数据小，说明还没找到正确的插入位置
            while (insertindex >= 0 && insertVal < array[insertindex]) {
                //insertIndex < 0 的话说明：有序序列遍历完都没找到比插入数据小的数
                //insertVal >= array[insertIndex] 的话说明：插入数据比有序序列中最后一个数（有序序列中最大的数）都大
                array[insertindex + 1] = array[insertindex];//有序序列中待插入索引处的数（上面已经判断是比待插入数据大的数）后移
                insertindex--;
            }

            array[insertindex + 1] = insertVal;

            System.out.println(Arrays.toString(array));
        }
        return array;

        //1.将第一个元素看成是有序序列，后面N-1个元素看成是(一个无序序列)
        //2.遍历无序序列，每一步将一个待排序的数据插入到前面已经排好序的有序序列中，直到插完所有元素为止
        //每一轮插入结束之后，有序序列多一个元素，无序序列少一个元素


//        //1.第1轮插入
//        //数组第一个元素是有序的，后面N-1个元素是无序的，第一个要插入的元素式array[1]
//        //插入索引为1-1=0
//        int insertVal = array[1];
//        int insertIndex = 1-1;
//        while (insertIndex >= 0 && insertVal < array[insertIndex]) {
//            //insertIndex >= 0,
//            //insertVal < array[insertIndex],要插入的数小于待插入索引处的数
//            array[insertIndex+1] = array[insertIndex];//有序序列中大的数后移
//            insertIndex--;//
//        }
//        array[insertIndex+1] = insertVal;
//        //2.第2轮插入
//        //数组前两个元素看作一个有序的序列，后面N-2个元素看作无序序列
//        //第一个要插入的元素就是array[2]
//        insertVal = array[2];
//        insertIndex = 2-1;
//        while(insertIndex>=0&&insertVal<array[insertIndex]){
//            array[insertIndex+1] = array[insertIndex];
//            insertIndex--;
//        }
//        array[insertIndex+1] = insertVal;
//        //3.第3轮插入
//        insertVal = array[3];
//        insertIndex = 3-1;
//        while(insertIndex>=0&&insertVal<array[insertIndex]){
//            array[insertIndex+1] = array[insertIndex];
//            insertIndex--;
//        }
//        array[insertIndex+1] = insertVal;
//        //4.第4轮插入
//        insertVal = array[4];
//        insertIndex = 4-1;
//        while(insertIndex>=0&&insertVal<array[insertIndex]){
//            array[insertIndex+1] = array[insertIndex];
//            insertIndex--;
//        }
//        array[insertIndex+1] = insertVal;
//        //5.第5轮插入
//        insertVal = array[5];
//        insertIndex = 5-1;
//        while(insertIndex>=0&&insertVal<array[insertIndex]){
//            array[insertIndex+1] = array[insertIndex];
//            insertIndex--;
//        }
//        array[insertIndex+1] = insertVal;
//        return array;
    }
}

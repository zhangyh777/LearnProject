package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 5, 2, 4, 6, 9, 8, 3};
        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void mergeSort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        //
        if(left<right){
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            //
            merge(array, left,mid,right);
        }

    }

    public static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int[] temp = new int[right - left + 1];//临时数组
        int index = 0;

        while (i <= mid && j <= right) {//
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }
        while (i <= mid) {//前半部分数据长，左边的i索引走不到中间索引排序就完成，直接将多出来的数据加到已经排序好的数组后边
            temp[index++] = array[i++];
        }
        while (j <= right) {//后半部分数据长，右边的j索引走不到尾部索引排序就完成，直接将多出来的数据加到已经排序好的数组后边
            temp[index++] = array[j++];
        }
        //把临时数组里的数据还原到原始数组
        for (int k = 0; k < temp.length; k++) {
            array[k + left] = temp[k];
        }


    }
}

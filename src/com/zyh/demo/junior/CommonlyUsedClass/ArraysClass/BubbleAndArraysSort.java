package com.zyh.demo.junior.CommonlyUsedClass.ArraysClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 冒泡排序+Arrays.sort定制排序
 */
public class BubbleAndArraysSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,9,1,3};
        int[] arr1 = Bubble01(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        Bubble02(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1-i2;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
//  冒泡排序从大到小
    public static int[] Bubble01(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        for(int i=0;i<newArr.length;i++){
            for(int j=0;j<newArr.length-i-1;j++){
                if(newArr[j]<newArr[j+1]){
                    int temp = newArr[j+1];
                    newArr[j+1] = newArr[j];
                    newArr[j] = temp;
                }
            }
        }
        return newArr;
    }
//  冒泡+定制排序
    public static void Bubble02(int[] arr,Comparator c){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
//              排序规则由compare方法决定
                if(c.compare(arr[j],arr[j+1])<0){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}


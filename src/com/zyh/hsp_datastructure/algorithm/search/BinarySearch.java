package com.zyh.hsp_datastructure.algorithm.search;

import java.util.ArrayList;

/**
 * 二分查找针对有序数组,如果数组是无序的要先排序成有序的
 * 二分查找思路：数组分半，每次查找一半
 * 但是假如我们找的值在最左边，或者最右边，那么就必须一次一次分割到最后才行了
 * 1.先确定数组中间值的下标,mid=(left+right)/2
 * 2.要找的findVal和arr[mid]比较,
 * 2.1.findVal小的话向左递归查找,
 * 2.2.findVal大的话向右递归查找,
 * 递归结束的情况：1.findVal找到了
 * 2.数组中找不到findVal,即 lefft>right时
 * 2.3.findVal==arr[mid]的话就找到了
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 9, 11, 47, 85, 91, 91, 91};//有序数组才能二分查找
//        int index = binarySearch1(arr, 0, arr.length - 1, 91);
        int index = binarySearch(arr,91);
        System.out.println(index);
        ArrayList<Integer> resList = binarySearch2(arr, 0, arr.length - 1, 91);
        System.out.println(resList);
    }


    //迭代法
    public static int binarySearch(int[] arr,int findVal) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];
            if (findVal == midVal) {
                return mid;
            }
            if (findVal > midVal) {
                left = mid + 1;
            }
            if (findVal < midVal) {
                right = mid - 1;
            }
        }
        return -1;
    }



    //递归法

    //1.只能查找一次findVal
    public static int binarySearch1(int[] arr, int left, int right, int findVal) {
        //其实也就是 mid=(left+right)/2,但加法可能会出现溢出的情况
        int mid = left + (right - left) / 2;

        int midVal = arr[mid];
        if (left > right) {//找不到的情况
            return -1;
        }
        if (findVal > midVal) {//向右递归
            return binarySearch1(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return binarySearch1(arr, left, mid - 1, findVal);
        } else {
            //findVal既不大于midVal也不小于midVal,但又找到了findVal,所以midVal等于findVal,返回midVal索引mid
            return mid;
        }
    }


    //2.数组中有多个findVal时可以返回全部的findVal索引
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        ArrayList<Integer> resList = new ArrayList<>();

        if (left > right) {
            return new ArrayList<Integer>();
        }

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //数组中有多个findVal时,查找全部的findVal,将全部索引存到ArrayList中
            //往左边找
            int temp = mid - 1;
            while (true) {
                if (temp < left || arr[temp] != findVal) {//左边的数组找完也没找到findVal或者遇到和findVal不相等的数时就停止继续查找(因为是有序数组,遇到和findVal不相等的数的话就说明前面也不会再有findVal)
                    break;
                }
                resList.add(temp);//找到findVal,索引temp存入ArrayList
                temp -= 1;//继续往左查找
            }

            resList.add(mid);

            //往右边找
            temp = mid + 1;
            while (true) {
                if (temp > right || arr[temp] != findVal) {//右边的数组找完也没找到findVal或者遇到和findVal不相等的数时就停止继续查找
                    break;
                }
                resList.add(temp);//找到findVal,索引temp存入ArrayList
                temp += 1;//继续往右查找
            }
        }
        return resList;
    }
}

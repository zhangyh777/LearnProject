package com.zyh.hsp_datastructure.algorithm.search;

import java.util.ArrayList;

/**
 * 插值查找法，二分查找的变体
 * mid值取值不同,二分查找使用固定mid,插值查找采用自适应mid
 * 二分查找 mid = (L+R)/2
 * 插值查找 mid = L + (L-R) * (findVal-array[L]) / (array[R]-array[L])
 * 结束递归的条件比二分查找多两个
 *
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8};
        ArrayList<Integer> res = insertValueSearch(arr, 0, arr.length - 1, 8);
        System.out.println(res);
    }

    public static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("***");

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];

        ArrayList<Integer> resList = new ArrayList<>();

        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            //没找到
            //要找的值比最小的值都小
            //要找的值比最大的值都大
            return new ArrayList<>();
        }
        if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);

        } else if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);

        } else {
            int temp = mid - 1;
            while (true) {
                if (temp < left || arr[temp] != findVal) {
                    break;
                }
                resList.add(temp);
                temp -= 1;
            }
            resList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > right || arr[temp] != findVal) {
                    break;
                }
                resList.add(temp);
                temp += 1;
            }
            return resList;
        }

    }

    //只能查找一次findVal
    public static int binarySearch1(int[] arr, int left, int right, int findVal) {
        System.out.println("***");

        int mid = (left + right) / 2;
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

}

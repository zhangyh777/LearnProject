package com.zyh.hsp_datastructure.algorithm.sort;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] array = {7, 6, 1, 2, 3, 5, 4, 9, 1};
        quickSort(array, 0, array.length - 1);//对数组指定区间排序
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int stand = array[(left + right) / 2];

        while (l < r) {
            while (array[r] > stand) {//从右往左，找比stand小的数，如果找的数比stand大的话就继续找
                r--;
            }//while循环结束时array[r]就是比stand小的数
            while (array[l] < stand) {//从左往右，找比stand大的数，如果找的数比stand小的话就继续找
                l++;
            }//while循环结束时array[l]就是比stand大的数

            if (l >= r) {//左边都是比stand小的数，右边都是比stand大的数了
                break;
            }

            //左边比stand大的数array[l] 和 右边比stand小的数array[r]交换位置
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            //交换之后，此时的array[l]是之前的array[r],array[r]==stand的话,r指针就得前移继续往左查找比stand小的数
            if (array[l] == stand) {
                r--;
            }
            //交换之后，此时的array[r]是之前的array[l],array[l]==stand的话,l指针就得后移继续往右查找比stand大的数
            if (array[r] == stand) {
                l++;
            }
        }//while循环结束之后，数据就被分割成三部分   小于等于stand的数 stand 大于等于stand的数

        if (l == r) {//左右指针移动,重新细分数组
            l += 1;
            r -= 1;
        }

        //左右分别递归排序
        if (left < r) {//左边递归，对stand左边的序列再排序
            quickSort(array, left, r);
        }
        if (l < right) {//右边递归，对stand右边的序列再排序
            quickSort(array, l, right);
        }
    }

    public static void quick(int[] arr, int start, int end) {
        if (start < end) {//只有排序序列的起点位置在前终点位置在后才排序（递归条件）
            int left = start;
            int right = end;
            int stand = arr[left];//基准值取最左（右）边的话,就得从反方向先查找
            while (left < right) {
                while (left < right && arr[right] >= stand) {//基准值取最左边的话，先从右往左找比stand小的数，arr[right]>stand的话就继续往左找
                    //此处的left<right条件是说：left左边的数都已经是比stand小的数，不用再往左找
                    right--;
                }//while循环结束就在右边找到了比stand小的数
                arr[left] = arr[right];

                while (left < right && arr[left] <= stand) {//后从左往右找比stand大的数，arr[left]<stand的话就继续找
                    left++;
                }//while循环结束就在左边找到了比stand大的数
                arr[right] = arr[left];
            }
            //while循环结束之后,left和right就碰面了
            //将stand放在此处,或者arr[right]=stand
            arr[left] = stand;

            //左边递归
            quick(arr, start, right - 1);
            //右边递归
            quick(arr, left + 1, end);

        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


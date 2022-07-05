package com.zyh.demo.primary.random;

import java.util.Random;

public class TestP187Random {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }
        System.out.print("原始数组:[");
        for (int e : arr
        ) {
            System.out.print(e + "\t");
        }
        System.out.println("]\n");
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
//      倒序打印
        System.out.print("倒序打印数组：[");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int e : arr
        ) {
            System.out.print(e + "\t");
        }
        System.out.print("]\n");

//      平均值，最大值和最小值的下标
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum = sum / arr.length;
        System.out.println("平均值sum=" + sum);

//      最大值的下标,用未排序的arr2
        int max = arr2[0];
        int maxIndex = 0;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
                maxIndex = i;
            }
        }
        System.out.println("maxIndex:" + maxIndex);
//      最小值的下标
        int min = arr2[0];
        int minIndex = 0;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] < min) {
                min = arr2[i];
                minIndex = i;
            }
        }
        System.out.println("minIndex:" + minIndex);
        int target = 25;
        int flag = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                flag = i;
                System.out.println("找到目标元素：" + target);
                break;
            }
        }
        if (flag == -1) {
            System.out.println("没找到.");
        }

    }

}

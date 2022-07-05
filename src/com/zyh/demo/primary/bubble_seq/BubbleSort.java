package com.zyh.demo.primary.bubble_seq;

import java.util.*;
public class BubbleSort {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        double[] score = new double[6];
        System.out.printf("输入数组元素（%d个）：",score.length);
        for(int i=0;i<score.length;i++) {
            score[i] = myScan.nextDouble();
        }

        System.out.print("原始数组：");
        System.out.println(Arrays.toString(score));

        System.out.println("通过冒泡排序方法对数组进行排序：");
        //N个数冒泡排序，一共要排 N-1 轮，
        for (int i = 0; i < score.length - 1; i++) {
            // 比较相邻两个元素，小数往前冒泡
            // 第 n 轮进行 N-n 次排序，第n轮倒数前n个数不进行排序(已排好)
            for (int j = 0; j < score.length - 1 - i; j++) {
//              从小到大排：arr[j] > arr[j+1]
//              从大到小排：arr[j] < arr[j+1]
                if (score[j] > score[j + 1]) {
                    double temp = score[j + 1]; // 把小数存到临时变量中
                    score[j + 1] = score[j];    // 把大数放到小数位置上
                    score[j] = temp;            // 把小数(临时变量表示)放到大数位置上
                }
            }
            System.out.println("\n第"+(i+1)+"轮");
            System.out.println(Arrays.toString(score));
        }

    }

}

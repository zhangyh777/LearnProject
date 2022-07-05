package com.zyh.demo.primary.bubble_seq;


import java.util.*;

//顺序查找：按顺序从头到尾依次往下查找，找到数据，则提前结束查找，找不到便一直查找下去，直到数据最后一位。
public class SeqSearch {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String[] arr = new String[5];
        System.out.println("输入字符串数组元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myScan.next();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.print("输入查找的字符串：");
        String target = myScan.next();

        int index = -1;

        for (int j = 0; j < arr.length; j++) {
//          字符串比较用   str1.equals(str2)
            if (target.equals(arr[j])) {
                System.out.printf("查找到目标元素,下标为%d", j);
                index = j;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没找到目标元素.");
        }
    }
}

package com.zyh.demo.primary.array;

import java.util.*;

public class ExpandArray01 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        int[] arr1 = {1,2,3};

        do {
            System.out.println(arr1.length);
            int[] arr2 = new int[arr1.length+1];

            System.arraycopy(arr1, 0, arr2, 0, arr1.length);
            System.out.println("输入要添加的元素：");
            int addNum = myScan.nextInt();
            arr2[arr1.length]=addNum;

            arr1 = arr2;

            for (int j : arr1) {
                System.out.print(j + "\t");
            }
            System.out.println("是否继续添加(y/n)?");
            char key = myScan.next().charAt(0);
            if(key=='n'){
                break;
            }
        }while (true);
        System.out.println("退出添加。");
    }
}

package com.zyh.demo;
import java.util.*;
public class TestP184Bubble {
    public static void main(String[] args){
        Scanner myScan=new Scanner(System.in);
        int[] arr1 = {10,12,45,90};
        int[] arr2 = new int[arr1.length+1];
        System.out.println("输入插入的元素：");
//      1.扩容
        int addNum = myScan.nextInt();
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];
        }
        arr2[arr2.length-1] = addNum;
        arr1=arr2;
        long startTime = System.currentTimeMillis();

        System.out.println("插入之后的数组：");
        for (int element: arr1) {
            System.out.print(element+"\t");
        }
        System.out.println();
//      2. 冒泡排序
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length-1;j++){
                if(arr1[j]>arr1[j+1]){
                    int temp = arr1[j+1];
                    arr1[j+1] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        System.out.println("排序后的数组");
        for (int e: arr1
             ) {
            System.out.print(e+"\t");
        }
        long endTime = System.currentTimeMillis();
        var times=endTime-startTime;
        System.out.println(times);
    }
}

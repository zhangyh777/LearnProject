package com.zyh.demo;

import java.util.Scanner;

public class TestP184Search {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        int[] arr1 = {10,21,31,47,57};
        int[] arr2 = new int[arr1.length+1];
        System.out.print("原始数组：");
        for (int e:arr1
             ) {
            System.out.print(e+"\t");
        }
        System.out.println();
        System.out.print("输入要插入的元素：");
        int addNum = myScan.nextInt();

//      定位插入元素的位置
        int index = -1;
        for(int i=0;i<arr1.length;i++){
            if(addNum<=arr1[i]){//要添加的数小于原始数组里的某个数
                index = i;
                break;//找到的话就停止查找
            }
            else{//要添加的数比原数组所有的数都大
                index = arr1.length;
            }
        }
        System.out.println(index);

        for(int i=0,j=0;i<arr2.length;i++){
            if(i != index){
                arr2[i]=arr1[j];
                j++;
            }
            else{
                arr2[i]=addNum;
            }
        }
        arr1=arr2;
        for (int e: arr2
             ) {
            System.out.println(e);

        }
    }
}

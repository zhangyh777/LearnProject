package com.zyh.demo.primary.bubble_seq;
import java.util.*;
//冒泡排序
public class Bubble {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        double[] arr = new double[5];
        System.out.printf("输入数组数据(%d个)：",arr.length);
        for(int i=0;i<arr.length;i++){
            arr[i]=myScan.nextInt();
        }
        System.out.print("原始数组：");
        System.out.println(Arrays.toString(arr));



        System.out.println("\n第一轮排序：");
        for(int i=0;i<4;i++){
            if(arr[i]>arr[i+1]){
                double temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("\n第二轮排序：");
        for(int i=0;i<3;i++){
            if(arr[i]>arr[i+1]){
                double temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));


        System.out.println("\n第三轮排序：");
        for(int i=0;i<2;i++){
            if(arr[i]>arr[i+1]){
                double temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("\n第四轮排序：");
        for(int i=0;i<1;i++){
            if(arr[i]>arr[i+1]){
                double temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}

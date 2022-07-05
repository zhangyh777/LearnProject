package com.zyh.demo.primary.array;

import java.util.*;
public class ReduceArray {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        int[] arr1 = {1,2,3,4,5};
        do {
            if(arr1.length>1){
                int[] arr2 = new int[arr1.length-1];
                for(int i = 0;i<arr2.length;i++){
                    arr2[i]=arr1[i];
                }
                arr1=arr2;
                System.out.println("缩减之后的数组：");
                for(int i =0;i<arr1.length;i++){
                    System.out.print(arr1[i]+"\t");

                }
                System.out.println("是否继续缩减？(y/n)");
                char key = myScan.next().charAt(0);
                if (key=='n'){
                    System.out.println("停止缩减.");
                    break;
                }
            }
            else{
                System.out.println("数组只剩一个元素，不再执行缩减");
                break;
            }

        }while (true);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }


    }
}

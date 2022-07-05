package com.zyh.demo.primary.array;
import java.util.Scanner;

//动态的扩容数组
public class ExpandArray {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
        System.out.println("扩容后数组的长度为：");
        int L=myScan.nextInt();
        int[] arr1 = {1,2,3};
        int[] arr2 = new int[L];
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];

        }
        var ExpandLength=L-arr1.length;
        for(int i=arr1.length,j=0;i<L;i++,j++){

            System.out.printf("输入扩容元素（共%d个,还剩%d个）：",L-arr1.length,ExpandLength-j);
            arr2[i]= myScan.nextInt();
        }
        for(int i=0;i<L;i++){
            System.out.println(arr2[i]);
        }
    }
}

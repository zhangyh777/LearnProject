package com.zyh.demo.primary.test;
import java.util.*;
//实现求某个double数组的最大值，并返回
public class Test01 {
    public static void main(String[] args){

        A01 a01 = new A01();
        double[] arr = a01.printarr();
        double max = a01.max(arr);
        System.out.println("数组最大元素为："+max);
    }
}
class A01{
    public A01(){}

    public double[] printarr(){
        Scanner myScan = new Scanner(System.in);
        System.out.print("输入数组长度：");
        int n = myScan.nextInt();
        System.out.printf("输入数组元素（%d位）：",n);
        double[] arr = new double[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = myScan.nextDouble();
        }
        System.out.print("数组：[");
        for (double e:arr
        ) {
            System.out.print(e+"\t");
        }
        System.out.println("]");
        return arr;
    }
    public double max(double[] arr){
        double m = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>m){
                m = arr[i];
            }
        }
        return m;
    }
}


package com.zyh.demo.primary.test;

public class Test04 {
    public static void main(String[] args){
        int[] arr1 = {1,2,3};
        A03 a03 = new A03();
        var arr2 = a03.copyArr(arr1);
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());
        arr1[2] = 1224;
        arr2[2] = 1987;
        for (int e:arr1
             ) {
            System.out.print(e+"\t");
        }System.out.println();

        for (int e:arr2
             ) {
            System.out.print(e+"\t");
        }System.out.println();
    }
}
class A03{
    public int[] copyArr(int[] arr){
        int[] newArr = new int[arr.length];
        for(int i=0;i<newArr.length;i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
}

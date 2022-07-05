package com.zyh.demo.primary.array;


import java.util.Arrays;

public class TwoDimsArray {
    public static void main(String[] args){
//      二维数组的元素是一维数组,其中一维数组可以等长也可以不等长
//      （1）一维数组等长的情况
        int[][] arr=new int[3][4];//3行4列
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = (int)(Math.random()*10);
            }
            System.out.println(Arrays.toString(arr[i]));
        }

//      （2）一维数组不等长,为每个一维数组单独分配空间
        double[][] arr2;
        arr2 = new double[3][];//3行，但每行不一定等长
        for(int i=0;i<arr2.length;i++){
//          为arr2的每个一维数组分配空间
            arr2[i]=new double[i+1];
            for(int j=0;j<arr2[i].length;j++){
                arr2[i][j]=Math.random();
            }
            System.out.println(Arrays.toString(arr2[i]));
        }
    }
    //n*n二维数组转置
    public static void transform(int[][] matrix){
        int row = matrix.length;
        int col = row;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

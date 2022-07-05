package com.zyh.demo.primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * 1.每一行元素的的个数和该行所在的行数是相同的,即第i行有i个数
 * 2.每行第一个数和最后一个数都为1
 * 3.从第三行开始，除了首尾两个数外，其余各数是该数的 上一行的同列数字 和 上一行的前一列的数字 这两个数之和，
 * 表示为 a[i][j]=a[i-1][j]+a[i-1][j-1]
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 。。。
 * 1 10 45 120 210 252 210 120 45 10 1
 */
public class YangHui {
    public static void main(String[] args) {
        int[][] yangHui = yangHui(5);
        for (int i = 0; i < yangHui.length; i++) {
            System.out.println(Arrays.toString(yangHui[i]));
        }
        List<List<Integer>> list = YangHui(5);
        System.out.println(list);

    }

    /**
     * 杨辉三角
     * @param rows  杨辉三角的行数
     * @return      二维数组的形式返回杨辉三角
     */
    public static int[][] yangHui(int rows){
        /*
            1.第i行有i+1个数
            2.每一行的头和尾都是1
            3.除了头尾的两个数之外,i行j列的数arr[i][j]=arr[i-1][j]+arr[i-1][j-1]
         */
        int[][] yangHui = new int[rows][];
        for (int i = 0; i < rows; i++) {
            yangHui[i] = new int[i+1];
            for (int j = 0; j < yangHui[i].length; j++) {
                if (j==0||j==yangHui[i].length-1){
                    yangHui[i][j]=1;
                }else {
                    yangHui[i][j] = yangHui[i-1][j]+yangHui[i-1][j-1];
                }
            }
        }
        return yangHui;
    }

    /**
     * 杨辉三角
     * @param rows
     * @return      List的形式返回杨辉三角
     */
    public static List<List<Integer>> YangHui(int rows){
        List<List<Integer>> yanghui = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();//行
            for (int j = 0; j <=i; j++) {
                if (j==0||j==i){
                    list.add(1);
                }else {
                    list.add(yanghui.get(i-1).get(j-1)+yanghui.get(i-1).get(j));
                }
            }
            yanghui.add(list);
        }
        return yanghui;
    }
}

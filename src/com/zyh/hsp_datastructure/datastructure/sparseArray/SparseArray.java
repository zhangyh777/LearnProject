package com.zyh.hsp_datastructure.datastructure.sparseArray;

import com.zyh.demo.primary.extend_.exercise.A;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[][] TwoDimArray = new int[11][11];
        TwoDimArray[1][2] = 1;
        TwoDimArray[3][4] = 2;
        TwoDimArray[5][6] = 2;
        print2DArray(TwoDimArray);
        //二维数组转稀疏数组
        //1.遍历二维数组获取有效数据个数
        //2.声明创建稀疏数组
        //3.将有效数据存入稀疏数组
        //1.
        int sum = 0;
        for (int i = 0; i < TwoDimArray.length; i++) {
            for (int j = 0; j < TwoDimArray[0].length; j++) {
                if (TwoDimArray[i][j] != 0) {
                    sum += 1;
                }
            }
        }
        //2.
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = TwoDimArray.length;
        sparseArr[0][1] = TwoDimArray[0].length;
        sparseArr[0][2] = sum;
        //3.
        int count = 0;
        for (int i = 0; i < TwoDimArray.length; i++) {
            for (int j = 0; j < TwoDimArray[0].length; j++) {
                if (TwoDimArray[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = TwoDimArray[i][j];
                }
            }
        }
        print2DArray(sparseArr);
//        //数组存盘
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\a.data"));
//        oos.writeObject(sparseArr);
//        oos.close();
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\a.data"));
//        Object o = ois.readObject();
//        int[][] readArr = (int[][]) o;
//        int[][] twoDimArr = new int[readArr[0][0]][readArr[0][1]];
//        for (int i = 1; i < readArr.length; i++) {
//            twoDimArr[readArr[i][0]][readArr[i][1]] = readArr[i][2];
//        }
//        print2DArray(twoDimArr);

        //稀疏数组恢复为二维数组
        //1.根据稀疏数组第0行的数据来声明创建二维数组
        //2.根据稀疏数组后面几行的数据恢复二维数组
        //1.
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] new2DArray = new int[row][col];
        //2.
        //从第二行(索引为1)开始是二维数组有效数据的信息
        //sparseArr[i][0]有效数据的行
        //sparseArr[i][1]有效数据的列
        for (int i = 1; i < sparseArr.length; i++) {
            new2DArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        print2DArray(new2DArray);

    }

    public static void print2DArray(int[][] TwoDimArray) {
        for (int i = 0; i < TwoDimArray.length; i++) {
            for (int j = 0; j < TwoDimArray[0].length; j++) {
                System.out.print(TwoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

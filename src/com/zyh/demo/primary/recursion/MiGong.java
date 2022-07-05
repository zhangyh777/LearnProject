package com.zyh.demo.primary.recursion;


/**
 * 二维数组表示迷宫（8行7列），0表示路，1表示障碍物
 * 1111111
 * 1000001
 * 1110001
 * 1000001
 * 1000001
 * 1000001
 * 1000001
 * 1111111
 */
public class MiGong {
    public static void main(String[] args){
        int[][] map = new int[8][7];
        T t = new T();
        t.printMiGong(map);
        t.findWay(map,1,1);
        System.out.println();
        t.printMiGong(map);
    }
}
class T {
    //  打印迷宫
    public void printMiGong(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

//      第一行和最后一行都为1
        for (int i = 0; i < col; i++) {
            arr[0][i] = 1;
            arr[row - 1][i] = 1;
        }
//      第一列和最后一列都为1
        for (int i = 0; i < row; i++) {
            arr[i][0] = 1;
            arr[i][col - 1] = 1;
        }


        arr[2][2]=1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //  找路函数，找到返回ture，没找到返回false，
    public boolean findWay(int[][] arr, int i, int j) {
        //  int[][] arr表示迷宫
        //  i和j表示人的初始位置
        //  出口在arr[6][5]
        //  走过且走得通的路标记为2，走过但走不通的路标记为3
        //  arr[6][5]=2时即走出迷宫,否则继续找
        //  找路策略：下->右->上->左
        if (arr[6][5] == 2) {//找到出口
            return true;
        }
        else {
            if (arr[i][j] == 0) {
                arr[i][j] = 2;//可以走的话就标记为2
//              可以走的话先往下走
                if (findWay(arr, i + 1, j)) {
                    return true;
                }
                //可以走的话再往右走
                else if (findWay(arr, i, j + 1)) {
                    return true;
                }
//              可以走的话再往上走
                else if (findWay(arr, i - 1, j)) {
                    return true;
                }
//              往左走
                else if (findWay(arr, i, j - 1)) {
                    return true;
                }
                else {
                    arr[i][j] = 3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    public boolean findWay2(int[][] arr, int i, int j) {
        //  int[][] arr表示迷宫
        //  i和j表示人的初始位置
        //  出口在arr[6][5]
        //  走过且走得通的路标记为2，走过但走不通的路标记为3
        //  arr[6][5]=2时即走出迷宫,否则继续找
        //  找路策略：右下左上
        if (arr[6][5] == 2) {//找到出口
            return true;
        }
        else {
            if (arr[i][j] == 0) {
                arr[i][j] = 2;//可以走的话就标记为2
//              右
                if (findWay2(arr, i , j+1)) {
                    return true;
                }
//              下
                else if (findWay2(arr, i+1, j )) {
                    return true;
                }
//              左
                else if (findWay2(arr, i , j-1)) {
                    return true;
                }
//              上
                else if (findWay2(arr, i-1, j )) {
                    return true;
                }
                else {
                    arr[i][j] = 3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }

}

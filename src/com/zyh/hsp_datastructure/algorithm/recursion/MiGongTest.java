package com.zyh.hsp_datastructure.algorithm.recursion;

public class MiGongTest {
    public static void main(String[] args) {
        //二维数组模拟迷宫,7行8列
        //1为墙
        int[][] miGongArray = miGong();
        int n1 = fun(miGongArray,1,1);
        System.out.println("n1="+n1);
        printMiGong(miGongArray);

    }
    public static int fun(int[][] arr,int i,int j){
        int count = 0;
        setWay(arr,i,j);
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[0].length; l++) {
                if(arr[i][j]==2){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * @param arr   迷宫
     * @param i     起点横坐标
     * @param j     起点纵坐标
     * @return
     * arr[][]初始状态下，除了墙为1，别的都为0
     * arr[i][j]为0：表示此处没走过
     * arr[i][j]为1：表示墙
     *          为2：表示可以走
     *          为3：表示已经走过，但走不通
     *
     * 出口：arr[6][5]
     * 寻路规则：下->右->上->左
     */
    public static boolean setWay(int[][] arr,int i,int j){
        if(arr[6][5]==2){//找到出口
            return true;
        }else{
            if(arr[i][j]==0){//如果该点没走过
                arr[i][j]=2;//假设该点可以走
                //寻路规则：下右上左
                if(setWay(arr,i+1,j)){//往下走
                    return true;
                }else if(setWay(arr,i,j+1)){//往右走
                    return true;
                }else if(setWay(arr,i-1,j)){//往上走
                    return true;
                }else if(setWay(arr,i,j-1)){//往左走
                    return true;
                }else{
                    arr[i][j] = 3;
                    return false;
                }
            }else{//arr[i][j]!=0; 三种情况：1,2,3,
                return false;
            }
        }


    }



    public static void printMiGong(int[][] miGongArray){
        for (int i = 0; i < miGongArray.length; i++) {
            for (int j = 0; j < miGongArray[0].length; j++) {
                System.out.print(miGongArray[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] miGong(){
        int[][] miGongArray = new int[8][7];
        miGongArray[3][1] = 1;
        miGongArray[3][2] = 1;
        //左右两列设为墙
        for (int i = 0; i < miGongArray.length; i++) {
            miGongArray[i][0] = 1;
            miGongArray[i][6] = 1;
        }
        //上下两行设为墙
        for (int i = 1; i < miGongArray[0].length; i++) {
            miGongArray[0][i] = 1;
            miGongArray[7][i] = 1;
        }
        return miGongArray;
    }
}

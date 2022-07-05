package com.zyh.hsp_datastructure.algorithm.recursion;

/**
 * 任意两个皇后不能在同一行，同一列，或者同一条斜线上
 */
public class Queen8 {
    static int resCount = 0;
    static int judgeCount = 0;
    int max = 8;//皇后个数
    int[] array = new int[max];//存放皇后的位置
                               //下标i代表第(i+1)个皇后
                               //array[i]代表该皇后(第i+1个皇后)放在(第i+1行的)第几列
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();

        queen8.check(0);
        System.out.println(resCount);
        System.out.println(judgeCount);
    }
    private void check(int n){
        if(n==max){//1.如果全部皇后都放置好了
            print();
            return;
        }else{
            //2.没有全部放置好的话
            for (int i = 0; i < max; i++) {
                array[n] = i;//3.将该皇后依次放在该行的第i列
                //检查放置是否合理
                if(judge(n)){//如果合理,开始放第n+1个皇后（递归）
                             //如果不合理,放到下一列（i++）
                    check(n+1);
                }
            }
        }
    }

    private void print(){
        resCount++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     *
     * @param n     第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //arr[i]==arr[n],在同一列
            //abs(arr[i]-arr[n])==abs(i-n),斜率为1,在同一条斜线上
            if(array[i]==array[n]||Math.abs(i-n)==Math.abs(array[i]-array[n])){
                return false;
            }
        }
        return true;
    }
}


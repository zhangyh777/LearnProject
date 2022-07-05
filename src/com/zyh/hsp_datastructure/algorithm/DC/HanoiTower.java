package com.zyh.hsp_datastructure.algorithm.DC;

/**
 * 分治算法解决汉诺塔问题
 */
public class HanoiTower {
    public static void main(String[] args) {
        move(4, 'a', 'b', 'c');
    }

    /**
     * 汉诺塔问题
     * 规则：只能把小盘子摞在大盘子上面
     * 一摞放好的盘子（num个）,把所有盘子从a位置挪到c位置,可以借助临时的temp位置
     *
     * @param num  盘子个数
     * @param a    盘子一开始在的位置
     * @param temp 临时的位置,借助这个位置把所有盘子从a挪到c
     * @param c    盘子最后在的位置
     */
    public static void move(int num, char a, char temp, char c) {
        if (num == 1) {//只有一个盘子
            System.out.println(a + "->" + c);
        } else {
            //把上面num-1个盘子看作一个盘子,借助c挪到temp位置
            //a位置上还剩一个最大的盘子,temp上是按规则摞好的num-1个盘子,c位置上没有盘子
            move(num - 1, a, c, temp);
            //把a位置上的盘子直接挪到c位置,a位置空出
            System.out.println(a + "->" + c);
            //把temp位置上的num-1（此时的num其实是num-1）个盘子看作一个盘子,借助a挪到c
            move(num - 1, temp, a, c);
        }
    }
}



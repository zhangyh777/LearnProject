package com.zyh.demo.primary.recursion;


// 三个位置ABC，A位置上从下往上按照大小顺序摞着num片圆盘
// 将圆盘从下面开始按照大小顺序重新放在另一个位置(B或者C)
// 小盘上不能放大盘，每次只能移动一个盘

public class HanoiTower {
    public static void main(String[] args) {
        Tower tower = new Tower();
        long starttime = System.currentTimeMillis();

        tower.move(4, 'a', 'b', 'c');


        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + " ms");
    }
}

class Tower {
    //  将a位置上的盘借助b位置，移动到c位置
//  num:要移动的盘的个数
//  a,b,c:三个位置
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            //只有一个盘的话，直接移动
            System.out.println(a + "->" + c);
        } else {
            //有多个盘（num）时，最下面的盘 和 上面的(num-1)个盘 看作两个盘

            //1.将a上面的（num-1）个盘移动到b，要借助c
            move(num - 1, a, c, b);
            //2.将a上的盘(最下面的一个盘)移动到c，直接移动
            System.out.println(a + "->" + c);
            //3.将b上的（num-1）个盘移动到c，借助a
            move(num - 1, b, a, c);
        }

    }
}

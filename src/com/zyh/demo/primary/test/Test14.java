package com.zyh.demo.primary.test;

import java.util.Random;
import java.util.Scanner;
public class Test14 {

    public static void main(String[] args) {
        Tom t = new Tom();
        char[] arr = t.play(5);
        for (char e : arr
        ) {
            System.out.print(e);
        }
    }
}

class Tom {
    char flag;

    public char[] play(int n) {
        Scanner myScan = new Scanner(System.in);
        Random r2 = new Random();

        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            System.out.print("出拳（0石头，1剪刀，2布）：");
            int num1 = myScan.nextInt();
            if (num1 < 0 || num1 > 2) {
                System.out.println("重新出拳！");
                i--;
            } else {
                int num2 = r2.nextInt(3);
                System.out.print("电脑出拳：");
                System.out.println(num2);
                if ((num1 - num2 == -1) || (num1 - num2 == 2)) {
                    System.out.println("赢");
                    System.out.println("=======");
                    flag = '赢';
                } else if ((num1 - num2 == -2) || (num1 - num2 == 1)) {
                    System.out.println("输");
                    System.out.println("=======");
                    flag = '输';
                } else {
                    System.out.println("平");
                    System.out.println("=======");
                    flag = '平';
                }
                arr[i] = flag;
            }
        }
        return arr;
    }
}

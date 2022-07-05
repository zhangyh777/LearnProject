package com.zyh.demo.junior.Exception;
import java.util.Scanner;
/**
 * 如果输入的不是一个整数，就提示重新输入，直到输入的是整数为止
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int num = 0;
        String intStr = "";
        while(true){
            System.out.println("输入一个整数：");
            intStr = myScan.next();
            try {
                num = Integer.parseInt(intStr);//
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入数据无法转成整数，重新输入！");
            }
        }
        System.out.println("num= "+num);


    }
}

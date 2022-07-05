package com.zyh.demo.junior.CommonlyUsedClass;
import java.util.Scanner;

/**
 * 输入商品名称，商品价格，将价格格式化输出（小数点前的整数部分，每隔三位加逗点）
 * 12345.6 -> 12,345.6
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入商品名称：");
        String name = scanner.next();

        System.out.println("输入商品价格：");
        String price = scanner.next();
        StringBuffer stringBufferPrice = new StringBuffer(price);
//      lastindexOf方法定位到小数点
        int index = stringBufferPrice.lastIndexOf(".");
        for(int i=index-3;i>0;i-=3){//index-3判断整数部分是否超过三位（不超过的话就不用加逗点）
            stringBufferPrice.insert(i,",");
        }
        System.out.println(stringBufferPrice);

    }
}


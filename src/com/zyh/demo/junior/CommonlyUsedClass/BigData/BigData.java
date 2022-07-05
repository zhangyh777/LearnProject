package com.zyh.demo.junior.CommonlyUsedClass.BigData;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * BigInteger:add.substract,multiply,divide
 * BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。因为Number定义了转换为基本类型的几个方法：
 * 转换为byte：byteValue()
 * 转换为short：shortValue()
 * 转换为int：intValue()
 * 转换为long：longValue()
 * 转换为float：floatValue()
 * 转换为double：doubleValue()
 *
 *
 *
 * BigDecimal:add,subtract,multiply,divide（可能会报异常，除不尽，需要指定精度）
 * scale，返回小数位数
 * divideAndRemainder，返回一个数组，分别是商和余数，可以利用这个方法判断两个BigDecimal是否是整数倍数
 * compareTo，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
 * 在比较两个BigDecimal的值是否相等时，要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等
 *
 */
public class BigData {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("777777777777777777");
        BigInteger bigInteger1 = new BigInteger("333");
        System.out.println(bigInteger.divide(bigInteger1));
        System.out.println(bigInteger.subtract(bigInteger1));
        System.out.println(bigInteger.multiply(bigInteger1));
        System.out.println(bigInteger.divide(bigInteger1));
        BigDecimal bigDecimal = new BigDecimal("77777.77777777777");
        BigDecimal bigDecimal1 = new BigDecimal("3.333");
        BigDecimal bigDecimal2 = new BigDecimal("3.33300");

        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
//      System.out.println(bigDecimal.divide(bigDecimal1));除不尽，报错
//      保留5位小数并四舍五入
        System.out.println(bigDecimal.divide(bigDecimal1,5, RoundingMode.HALF_UP));
//      divideAndRemainder
        BigDecimal[] arr = bigDecimal.divideAndRemainder(bigDecimal1);
        System.out.println("商："+arr[0]);
        System.out.println("余数："+arr[1]);
//      小数位数
        System.out.println(bigDecimal.scale());
//      比较两个BigDecimal的大小，compareTo
//      equals方法比较BigDecimal大小时，还要求精度一样
        System.out.println(bigDecimal1.equals(bigDecimal2));//false
        System.out.println(bigDecimal1.compareTo(bigDecimal2));//0

    }
}

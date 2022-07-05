package com.zyh.demo.junior.CommonlyUsedClass.WrapperClass;

/**
 * | 基本类型   | 对应的引用类型                | 对应的父类  |
 * | boolean  | java.lang.Boolean           | Object类  |
 * | char     | java.lang.Character         | Object类  |
 * | byte     | java.lang.Byte              | Number类  |
 * | short    | java.lang.Short             | Number类  |
 * | int      | java.lang.Integer           | Number类  |
 * | long     | java.lang.Long              | Number类  |
 * | float    | java.lang.Float             | Number类  |
 * | double   | java.lang.Double            | Number类  |
 * 装箱：基本数据类型 -> 包装类
 * 拆箱：包装类 -> 基本数据类型
 * 自动和手动两种方式
*         public static Integer valueOf(int i) {
*           //low = -128,high = 127
*           if (i >= IntegerCache.low && i <= IntegerCache.high)
*             return IntegerCache.cache[i + (-IntegerCache.low)];
*         return new Integer(i);
 *     }
 */
public class Wrapper {
    public static void main(String[] args) {
        int n1 = 100;
//      手动装箱
//      过时
        Integer integer = new Integer(n1);
//      valuesOf(n1),n1在[-128,127]范围，则从底层缓存数组中返回实例，否则新建实例
//      如果n1==n2,并且都在该范围内，则两个实例引用的是同一个地址
        Integer i1 = 127;//底层自动调用Integer.valuesOf()
        Integer i2 = Integer.valueOf(127);

        Integer i3 = Integer.valueOf(128);
        Integer i4 = Integer.valueOf(128);
        System.out.println(i1==i2);//true
        System.out.println(i3==i4);//false

//      手动拆箱
        int i = integer.intValue();

//      自动装箱（底层自动调用valueof）
        int n2 = 200;
        Integer integer2 = n2;
//      自动拆箱（底层自动调用intValue）
        int n3 = integer2;

//      包装类 -> String
        Integer I = 10;
//      1.  toString
        String s = I.toString();
//      2.  valueOf
        String s1 = String.valueOf(I);
//      3.  + ""
        String s2 = I +"";
        System.out.println(s+"\t"+s1+"\t"+s2);
//      String -> 包装类
//      1.  String对象做参数，新建包装类对象
        Integer j = new Integer(s);
//      2.  valueOf
        Integer j1 = Integer.valueOf(s);
//      3.  parsexxx
        Integer j2 = Integer.parseInt(s);

    }
}


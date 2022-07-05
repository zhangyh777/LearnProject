package com.zyh.demo.junior.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws {
    public static void main(String[] args){
        f();
    }

//  1.对于编译时异常，必须处理，try-catch或者throws
//  2.对于运行时异常，程序中如果没有处理，默认throws方式抛出
//  3.子类重写父类的方法时，对抛出异常的规定：
//    子类重写的方法，抛出的异常类型要么和父类抛出异常类型一致，要么是父类抛出异常的子类
//  4.在throws过程中，如果有try-catch，相当于处理异常，就可以不必throws
    public static void f() throws RuntimeException{
        int n1 = 10;
        int n2 = 0;
        double res = n1/n2;
    }
//  抛出编译异常
    public static void f1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("E://AA.txt");
    }
//  抛出运行异常
    public static void f2() throws ArrayIndexOutOfBoundsException{}
//  不能在默认抛出异常情况下直接调用抛出编译异常的方法，需要显式的写出抛出异常类型
    public static void f3() /*throws FileNotFoundException*/ {
//      f1();//报错，因为f1()会抛出一个编译异常，导致f2()必须去处理这个异常
//      try-catch处理或者f2()同样抛出编译异常
        try {
            f1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        f2();//f2()抛出的是运行异常，有默认处理机制，不会报错
    }

}


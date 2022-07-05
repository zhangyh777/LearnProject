package com.zyh.demo.primary.extend_;

public class Extends01 {
    public static void main(String[] args) {
        Base base1 = new Base();
        System.out.println("=======");

        Base base2 = new Base("zyh");
        System.out.println("=======");

        Base base3 = new Base("satomi",33);
        System.out.println("=======");

        Sub sub1 = new Sub();
        System.out.println("=======");

        Sub sub2 = new Sub("zyh");
        System.out.println("=======");

        Sub sub3 = new Sub("zyh",24);


    }
}
class Base{
    public Base(){
        System.out.println("父类的Base()构造器被调用.");
    }
    public Base(String name){
        System.out.println("父类的Base(String name)构造器被调用.");
    }
    public Base(String name,int age){
        System.out.println("父类的Base(String name,int age)构造器被调用.");
    }
}
class  Sub extends Base{

    public Sub(){
        System.out.println("子类的Sub()构造器被调用");
    }

//  指定调用父类的哪一个构造器
    public Sub(String name){
//      不显式的调用父类的构造器，会默认调用父类的无参构造器
        System.out.println("子类的Sub(String name)被调用");
    }
    public Sub(String name,int age){
        super(name,age);
        System.out.println("子类的Sub(String name,int age)被调用");

    }
}

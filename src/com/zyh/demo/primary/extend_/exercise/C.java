package com.zyh.demo.primary.extend_.exercise;

public class C extends B{
    public C(){
        this("hello");
        System.out.println("我是C类的无参构造器C()");
    }
    public C(String name){
        super("hhhhhhh");
        System.out.println("我是C类的有参构造器C(String name)");
    }
}

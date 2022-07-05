package com.zyh.demo.primary.extend_.exercise;

public class B extends A{
    public B(){
        System.out.println("我是B类的无参构造器");
    }

    public B(String name) {
        System.out.println(name+" 我是B类的有参构造器B(String name)");
    }
}

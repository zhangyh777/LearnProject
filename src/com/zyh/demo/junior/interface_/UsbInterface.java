package com.zyh.demo.junior.interface_;

//  创建接口，public interface 接口名{...}
//  接口的修饰符只能是public和default，实现接口的类 的修饰符也是这样
//  接口不能继承类，但能继承多个别的接口
//  public interface InterfaceA extends InterfaceB{}
public interface UsbInterface {
//  自己的属性（public static final）
//  类要实现的抽象方法（public abstract）
//  自己的方法，default修饰

//  接口用来描述类应该做什么，而不指定他们具体应该怎么做
//  接口中的方法自动都是public abstract方法，不用再加public abstract修饰符
//  也有接口自己的具体方法，要用default修饰
    public int num = 1224;
    public abstract void start();
    void stop();
    default void say(){
        System.out.println("接口的具体方法，default修饰");
    }
}

package com.zyh.demo.junior.interface_;
//  类通过 implements 实现接口（实现接口定义的所有抽象方法）
//  一个类可以实现多个接口
//  抽象类实现接口的话，可以不必实现接口的抽象方法
public class Phone implements UsbInterface{
//  自己的属性
//  自己的方法
//  具体实现接口的抽象方法
    int number = 119;
    public int getNumber(){
        return number;
    }
    @Override
    public void start(){
        System.out.println("手机连接成功");
    }
    @Override
    public void stop(){
        System.out.println("手机断开连接");
    }

}

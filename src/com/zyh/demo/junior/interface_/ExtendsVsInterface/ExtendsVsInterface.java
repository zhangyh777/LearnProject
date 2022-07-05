package com.zyh.demo.junior.interface_.ExtendsVsInterface;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.fly();
    }
}
//  接口
interface Fish{
    void swimming();
}
interface Bird{
    void fly();
}
//  父类
class Monkey{
    public String name;

    public Monkey(String name) {
        this.name = name;
    }
    public void climbing(){
        System.out.println(name+"会爬树");
    }
}
//  子类，继承 + 实现接口
class LittleMonkey extends Monkey implements Fish,Bird{
//  实现接口的抽象方法
    @Override
    public void fly() {
        System.out.println(name+"学会了飞翔");
    }

    @Override
    public void swimming() {
        System.out.println(name+"学会了游泳");
    }

    public LittleMonkey(String name) {
        super(name);
    }

}

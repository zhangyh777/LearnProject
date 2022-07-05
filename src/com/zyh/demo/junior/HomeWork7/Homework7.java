package com.zyh.demo.junior.HomeWork7;
/**
 * 1.交通工具接口Vehicles，work功能
 * 2.Horse类和Boat类实现Vehicles接口
 * 3.创建交通工具工厂类VehiclesFactory，有两个方法分别获得Horse和Boat
 * 4.Perosn类，私有属性name和vehicle，有参构造器
 * 5.实例化Person对象”唐僧“，交通工具：一般情况下用Horse，过河的时候用Boat
 * 6.扩展：过火焰山使用飞机
 */
public class Homework7 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧",new Boat());
        tang.common();
        tang.river();
        tang.common();
        tang.common();
        tang.river();
        tang.river();

    }
}


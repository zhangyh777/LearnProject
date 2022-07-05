package com.zyh.demo;

/**
 * 编写一个方法copyClass，可以复制一个Person对象，返回复制的对象。
 * 克隆对象，得到的新对象和原来的对象是两个独立的对象，只不过属性相同。
 * 思路：
 * 1.返回类型：Person
 * 2.方法名字：copyClass
 * 3.方法形参：Person p
 * 4.方法体：创建一个新对象，复制传入对象的属性，返回新对象
 */
public class Test01 {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "zyh";
        p1.age = 24;
        Mytool tool = new Mytool();

        Person p2 = tool.copyClass(p1);
        System.out.println("p1 name:"+p1.name+"\t"+"p1 age:"+p1.age);
        System.out.println("p2 name:"+p2.name+"\t"+"p2 age:"+p2.age);
        p1.name = "satomi";
        System.out.println("p2 name:"+p2.name+"\t"+"p2 age:"+p2.age);

        System.out.println(p1==p2);

    }
}
class Person{
    String name;
    int age;
}
class Mytool{
    public Person copyClass(Person p){
        Person p2 = new Person();
        p2.name = "ZYH";
        p2.age = p.age;
        return p2;
    }
}

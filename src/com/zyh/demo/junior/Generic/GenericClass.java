package com.zyh.demo.junior.Generic;

import java.util.ArrayList;

/**
 * 引入泛型：可以代表数据类型的数据类型
 * 传统不使用泛型的集合不能对数据类型进行限制，都是Object类，在向下转型时很麻烦，还可能出错
 * 泛型的好处是使用时不必对类型进行强制转换，它通过编译器对类型进行检查，将运行时的问题提前到了编译时
 *
 * 1.可以在类声明时通过一个标识来表示类中某个属性的类型，或者某个方法的返回值类型，或者是参数类型
 * 2.泛型不能用在静态方法中
 * 3.泛型只能是引用类型，不能是基本数据类型
 * 4.指定泛型的具体类型后，可以传入该类型的子类类型
 * 5.可以省略编译器能自动推断出的类型，ArrayList<Dog> dogs = new ArrayList<>();
 * 6.使用泛型的数组，不能初始化
 * 7.泛型不具备继承性
 *   List<Object> list = new ArrayList<String>();不行
 * 通配符
 * 8.<?>支持任意泛型
 * 9.<? extends A>支持A类以及A类的子类，规定了泛型的上限
 * 10.<? super A>支持A类以及A类的父类，不局限于直接父类，规定了泛型的下限
 */
public class GenericClass {
    public static void main(String[] args) {

        Dog dog1 = new Dog("a",25);
        Dog dog2 = new Dog("bb",20);
        Dog dog3 = new Dog("ccc",28);
        Cat cat1 = new Cat("dddd",3);
//      没使用泛型，list里可以存放任意类型数据
        ArrayList list = new ArrayList();
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
//      list.add(cat1);//可以存
        for (Object obj:list
        ) {
//          list里面存放的是Object类或其任意子类对象
//          list里面不是只有Dog对象，如果存在其他类型的对象，此处向下转型报错，ClassCastException
            Dog d = (Dog) obj;
            System.out.println(d.getName()+"-"+d.getAge());
        }

//      使用泛型，dogs里面只能存放指定类型数据或者其子类
//      可以省略编译器能自动推断出的类型，
//      ArrayList<Dog> dogs = new ArrayList();//可以
        ArrayList<Dog> dogs = new ArrayList<Dog>();

        dogs.add(dog1);//可以存
        dogs.add(dog2);
        dogs.add(dog3);

//      dogs.add(cat1);//不能存
        for (Dog dog:dogs
        ) {
            System.out.println(dog.getName()+"-"+dog.getAge());
        }
//      创建对象时指定泛型表示的具体类型
        P<Integer> ap1 = new P<Integer>(1224);
        P<String> ap2 = new P<String>("aaa");
        Integer a = ap1.getName();
        String b = ap2.getName();
        ap1.setName(1987);//Integer类型
        ap2.setName("satomi");//String类型


    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
//在类声明时通过标识A来标识属性类型，在使用构造器时具体指出是什么类型
class P<A>{
//  属性值类型
    private A name;
    public P(A name) {
        this.name = name;
    }
//  方法返回值类型
    public A getName(){
        return name;
    }
//  方法的参数类型
    public void setName(A newName){
        name = newName;
    }
}
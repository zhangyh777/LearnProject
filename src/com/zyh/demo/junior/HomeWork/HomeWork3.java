package com.zyh.demo.junior.HomeWork;

public class HomeWork3 {
    public static void main(String[] args) {

    }
}
abstract class Animal{
    public abstract void shout();
}
class Cat extends Animal{
    @Override
    public void shout(){
        System.out.println("猫咪喵喵叫");
    }
}
class Dog extends Animal{
    @Override
    public void shout(){
        System.out.println("小狗汪汪叫");
    }
}
class Test{

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
package com.zyh.demo.junior.AbstractClass;

/**
 * 1. 抽象类的本质还是类，具有所有类的属性特征，（非）抽象方法，属性，构造器等等
 * 2. abstract只能修饰类和方法，不能修饰属性
 * 3. 抽象类不能实例化，即不能new创建对象
 * 4. 抽象类可以没有抽象方法，但只要一个类有抽象方法就必须要声明为抽象类
 * 5. 一个类B继承于抽象父类A，则类B就必须要实现抽象类A的所有抽象方法
 * 6. 抽象方法不能用private，final，static修饰（因为要保证子类能重写父类抽象方法）
 * 7. 抽象方法没有方法体，即没有 {...}，abstract fun();
 * 8. 可以创建抽象类的对象变量，但只能指向具体子类
 */
public class AbstractClass {
    public static void main(String[] args) {
        B b = new B();
        b.say();
    }

}
abstract class A{
//  抽象方法没有方法体
    public abstract void say();
    public abstract void cale(int n1,int n2);
    public void funA(){
        System.out.println("抽象类A的具体方法funA()");
    }

}
class B extends A{
//  重写抽象父类的所有抽象方法
    @Override
    public void say(){
        System.out.println("具体子类的具体方法say()");
    }
    @Override
    public void cale(int n1,int n2){
        System.out.println(n1 + n2 + "=" + (n1+n2));
    }
}

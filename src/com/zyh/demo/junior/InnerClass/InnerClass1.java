package com.zyh.demo.junior.InnerClass;

/**
 * 内部类：在类的内部再定义类，内部类可以直接访问外部类的所有成员，包括私有的
 *        内部类的实例不能单独存在，必须依附于一个外部类的实例
 *        内部类不能有静态方法，如果有的话也只能访问外部类的静态字段和静态方法
 * 1. 定义在外部类的局部位置上
 *    1.1 局部内部类（有类名）
 *        1.1.1 定义在外部类的方法内部或者代码块内部，本质也是类，有类的所有特性
 *        1.1.2 可以直接访问外部类的所有成员，包括私有的
 *        1.1.3 地位相当于局部变量，不能添加访问修饰符，但能用final修饰
 *        1.1.4 作用域：定义它的方法内部或者代码块内部
 *        1.1.5 外部类如果想使用局部内部类：
 *              在定义内部类的方法或者代码块中创建内部类对象，然后调用内部类的成员即可
 *        1.1.6 外部其他类无法访问局部内部类
 *        1.1.7 如果外部类和局部内部类成员重名时，默认遵循就近原则，
 *              如果想访问外部类的成员，可以使用  外部类名.this.成员 访问
 *
 *    1.2 匿名内部类（没有类名），基于接口或者基于类
 *
 * 2. 定义在外部类的成员位置上
 *    2.1 成员内部类（没有static修饰）
 *    2.2 静态内部类（static修饰）
 *
 */
public class InnerClass1 {//外部其他类
    public static void main(String[] args) {
        Aouter aouter = new Aouter("zyh");
        aouter.f1();
        aouter.f2();
    }
}
class Aouter{//外部类
    private int age = 18;
    private String name;//私有属性
    public void f1(){//方法
        System.out.println("Aouter类的f1方法");
    }
    public void f2(){
        //局部内部类(本质也是一个类)，定义在外部类的方法中或者代码块中
        //可以直接访问外部类的所有成员，包括私有的
        //不能添加访问修饰符，但能用final修饰
        class Ainner{
            //局部内部类成员和外部类成员同名，就近原则调用
            //如果想访问外部类的成员时，用  外部类名.this.成员名  访问
            private int age = 24;
            public void f(){
                System.out.println("Ainner类的f方法，可以访问外部类的所有成员.");
                //直接访问外部类的成员
                f1();
                System.out.println("内部类 age= "+age);
                System.out.println("外部类 age= "+Aouter.this.age);

            }
        }
//      外部类如果想访问内部类的成员，需要在定义内部类的方法或者代码块中创建内部类对象，
//      然后调用内部类的成员即可
        Ainner ainner = new Ainner();
        ainner.f();
    }

    public Aouter(String Nname){//构造器
        this.name = name;
    }
    {   //代码块
        System.out.println("A类的普通代码块");
    }
}
class B{//外部其他类

}
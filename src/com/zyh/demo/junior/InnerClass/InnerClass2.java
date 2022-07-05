package com.zyh.demo.junior.InnerClass;

/**
 * 匿名内部类：和局部内部类一样定义在外部类的方法中或者代码块中，不过没有名字，
 * 既是类，也是对象
 *  有两种，一种基于接口，一种基于类，创建方式：
 *  类/接口 实例名 = new 类/接口(参数列表){重写方法}；

 *  可以当作实参传递
 */
public class InnerClass2 {
    public static void main(String[] args) {

        Aouter2 aouter = new Aouter2("zyh");
        aouter.f2();
//      匿名内部类当作实参传递
        f1(new IA() {
            @Override
            public void cry() {
                System.out.println("匿名内部类当作实参传递");
            }
        });
    }
    public static void f1(IA i){
        i.cry();
    }
}
class Aouter2{
    private String name;
    private int age = 18;

    public Aouter2(String name) {
        this.name = name;
    }
    public void f1(){
        System.out.println("Aouter类的f1方法");
    }
    public void f2(){
        //基于接口的匿名内部类
        //ia的编译类型是 接口IA
        //运行类型就是 匿名内部类
//      IA I1 = new IA();是错误的，不存在创建接口的语句
        IA ia = new IA(){
            @Override
            public void cry(){
                System.out.println("基于接口的匿名内部类");
            }
        };
        ia.cry();
        //基于类的匿名内部类，直接创建具体对象，调用方法
        new Dog(){}.eat();
        //基于匿名类的匿名内部类，Cat是个匿名类，需要具体其中的抽象方法
        Cat cat = new Cat(){
            @Override
            void eat() {
                System.out.println("猫咪吃小鱼干");
            }
        };
        cat.eat();

        //传统方法，创建实现接口功能的类对象，调用方法
        IA tiger = new Tiger();
        tiger.cry();

    }
    {
        System.out.println("Aouter2普通代码块");
    }
}

interface IA{
    void cry();
}
class Tiger implements IA{
    public void cry(){
        System.out.println("老虎嗷嗷叫");
    }
}
class Dog{
    private String kind;

    public void eat(){
        System.out.println("狗啃骨头");
    }
}
abstract class Cat{
    abstract void eat();
}

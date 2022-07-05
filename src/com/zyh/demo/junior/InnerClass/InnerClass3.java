package com.zyh.demo.junior.InnerClass;

/**
 *  成员内部类
 *  * 成员内部类定义在外部类的成员位置上，地位相当于外部类的成员
 *  * 可以使用public,protected,private,default修饰符修饰（相当于外部类成员）
 *  * 作用域：整个外部类体内
 *  * 成员内部类可以直接访问外部类的所有成员
 *  * 外部类想访问成员内部类，创建成员内部类对象，直接访问
 *  * 如果外部类和成员内部类成员重名时，默认遵循就近原则，
 *    如果想访问外部类的成员，可以使用  外部类名.this.成员 访问
 *
 */
public class InnerClass3 {
    public static void main(String[] args) {
        Person person = new Person();
        person.f();
//      外部其他类也能访问成员内部类
//      方法1：
//      1. 先在外部其他类里面创建 外部类对象
//      2. 外部类.内部类 xxx = 外部类对象.new 内部类();
        Person.P inner = person.new P();
        inner.say();
//      方法2：
//      外部类里面定义一个方法，返回值为 内部类对象
        var pp =person.getInstanceP();
        pp.say();
//      方法3：
//      创建外部类对象，接着创建外部类对象
        Person.P p = new Person().new P();
        p.say();
    }
}
class Person{
    private String name = "zyh";
    private int age = 18;
    public void info(){
        System.out.println("外部类Person的info方法");
    }
//  成员内部类，定义在外部类的成员位置上
//  1. 可以直接访问外部类的所有成员
//  2. 其地位相当于外部类的成员，可以使用private,protected,default,public修饰符修饰
    class P{
        public void say(){
            System.out.println("name="+name);
            info();
        }
    }
//  外部类访问成员内部类
    public void f(){
//      方法内创建成员内部类对象，直接访问
        P p = new P();
        p.say();
    }
//  定义方法，返回值为 成员内部类对象
    public P getInstanceP(){
        return new P();
    }
}

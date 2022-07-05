package com.zyh.demo.junior.InnerClass;

/**
 * 静态内部类：static修饰，定义在外部类的成员位置上
 * 因为static修饰的原因，可以直接访问外部类的静态成员，但不能访问普通成员
 * 静态内部类访问外部类，外部类访问静态内部类  和成员内部类规则方法一样
 * 外部其他类如果想访问静态内部类：
 * 方法1：因为是静态的，所以可以通过类名访问
 * 方法2：外部类创建方法，返回值为静态内部类对象
 * 外部类和静态内部类成员重名：就近原则，如果指定访问外部类成员时，使用 外部类名.成员 访问
 */
public class InnerClass4 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.f();
//      外部其他类访问静态内部类
//      1.通过类名直接访问
        AA.SA sa = new AA.SA();
        sa.SAsay();
//      2.外部类创建方法，返回值为静态内部类对象
        var sa1 = aa.getInstancaSA();
        sa1.SAsay();

    }
}
class AA{
    public String name = "zyh";
    private static int age=18;
    public static void say(){
        System.out.println("调用外部类的静态方法");
    }
//  静态内部类，只能直接访问外部类的静态成员
    static class SA{
        public void SAsay(){
            int age = 24;
            AA.say();
            System.out.println("调用静态内部类的方法");
            System.out.println(age);
//          指定访问外部类的重名成员
            System.out.println(AA.age);
        }
    }
    public void f(){
        SA sa = new SA();
        sa.SAsay();
    }
    public SA getInstancaSA(){
        return new SA();
    }
}

package com.zyh.demo.junior.pattern.TemplatePattern;

/**
 * 模板模式：抽象类公开定义了执行它的方法的模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
 * 父类中定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 * 优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现
 * 缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 */
public class TemplatePattern {
    public static void main(String[] args) {
        A a = new A();
        a.cal();
        B b = new B();
        b.cal();
    }
}
abstract class Template{
    //将子类逻辑相同的方法抽象到父类的抽象方法中，之后在子类中具体实现相应的功能
    public abstract void job();
    //  算法骨架
    public void cal(){
        long start = System.currentTimeMillis();

        job();
        long end = System.currentTimeMillis();
        System.out.println("运行时间= "+(end-start)+" ms");
    }
}
class A extends Template{
    //  子类A具体实现父类的抽象方法
    public void job(){
        long sum = 0;
        for(int i = 1;i<1000000;i++){
            sum += i;
        }
    }
}
class B extends  Template{
    //  子类B具体实现父类的抽象方法
    public void job(){
        long mul = 0;
        for(int j = 1;j<100000;j++){
            mul *= j;
        }
    }
}


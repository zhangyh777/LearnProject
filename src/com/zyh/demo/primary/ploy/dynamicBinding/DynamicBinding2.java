package com.zyh.demo.primary.ploy.dynamicBinding;
/**
调用对象的方法时，方法会和该对象的 内存地址/运行类型 绑定
 */
public class DynamicBinding2 {
    public static void main(String[] args) {
        A2 a = new B2();

        System.out.println(a.sum());//30
//      a编译类型为A2,运行类型为B2,调用方法时从B2类开始
//      B2类没有sum()方法，往上到A2中找
//      A2 sum():    public int sum(){return getI()+10;}
//      这里的getI()遵守动态绑定机制，和 a的运行类型B2 绑定，转头去B2中调用getI()
//      B2 getI():   int i = 20;public int getI() {return i;}
        System.out.println(a.sum1());//
    }
}
class A2{
    int i = 10;
    public int getI(){
        return i;
    }
    public int sum(){
        return getI()+10;
    }
    public int sum1(){
        return i+10;
    }
}
class B2 extends A2{
    int i = 20;
    public int getI() {
        return i;
    }
//    public int sum() {
//        return i+20;
//    }
    public int sum1() {
        return i+10;
    }
}
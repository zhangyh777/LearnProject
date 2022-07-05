package com.zyh.demo.primary.ploy.dynamicBinding;

/**
 * 调用对象的属性时，没有动态绑定机制，哪里声明，哪里使用，没有声明的话按继承机制走
 */
public class DynamicBinding3 {
    public static void main(String[] args) {
        A3 a = new B3();
        System.out.println(a.sum());//40

//      对象a编译类型为A3,运行类型为B3,调用sum1()方法时从B3中调
//      B3中没有sum1()方法，往上去A3中调
//      A3 sum1():      int i = 10;public int sum1(){return i+10;}
//      调用属性时没有动态绑定机制，哪里声明，哪里使用，此处 i = 10;
        System.out.println(a.sum1());//20
    }
}

class A3{
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

class B3 extends A3{
    int i = 20;
    public int getI() {
        return i;
    }
    public int sum() {
        return i+20;
    }
//    public int sum1() {
//        return i+10;
//    }
}
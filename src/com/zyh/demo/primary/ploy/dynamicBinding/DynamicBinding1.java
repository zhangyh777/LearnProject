package com.zyh.demo.primary.ploy.dynamicBinding;

public class DynamicBinding1 {
    public static void main(String[] args) {
        A1 a = new B1();
        System.out.println(a.sum());//40
        System.out.println(a.sum1());//30
    }
}
class A1{
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
class B1 extends A1{
    int i = 20;
    public int getI() {
        return i;
    }
    public int sum() {
        return i+20;
    }
    public int sum1() {
        return i+10;
    }
}
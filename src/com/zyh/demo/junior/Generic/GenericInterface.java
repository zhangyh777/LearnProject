package com.zyh.demo.junior.Generic;

/**
 *  1.在接口中，静态成员也不能使用泛型（和泛型类规定一样）
 *  2.泛型接口的类型，在继承接口或者实现接口时指定
 *  3.不指定类型，默认为Object
 */
public class GenericInterface {
    public static void main(String[] args) {

    }
}
//泛型接口
interface IUsb<A,B>{
//  1.接口的属性都是static的，不能使用泛型
    int n = 1224;
//    A name = "zyh";//name是静态成员，不能使用泛型
//  普通方法使用泛型
    public abstract A get(B b);
    public abstract void say(A a);
    public abstract void run(A a1, B b1);
}
//泛型接口的类型要在继承接口或者实现接口时指定
interface IusbI extends IUsb<String,Integer>{}
class IUsbC implements IUsb<Integer,Double>{
    @Override
    public Integer get(Double b){
        return 1;
    }
    @Override
    public void say(Integer a){}
    @Override
    public void run(Integer a1,Double b1){}
}

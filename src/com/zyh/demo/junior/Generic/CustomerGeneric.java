package com.zyh.demo.junior.Generic;

/**
 * 自定义泛型
 */
public class CustomerGeneric {
    public static void main(String[] args) {
        Tiger<String, Integer, String> tiger1 = new Tiger("zyh", "satomi", 24, "987-12-24");
        tiger1.getA(tiger1.name);

//      调用泛型方法,方法前的泛型指定可以省略，编译器会根据传入的参数类型确定类型
//      类型指定不能是基本数据类型
        tiger1.<String,Character>say("aaa",'c');
        tiger1.say(1987,12.24f);

    }
}
//自定义泛型
//A,B,C 为泛型标识，在创建对象时需要确定具体类型
class Tiger<A,B,C>{
    String name;
//  1.使用泛型的数组不能初始化，但能声明
//  new的时候不能确定数据类型，无法开辟空间
    A[] A_arr;//行
//  B[] B_arr = new B[5];//不行
//  可以先创建Object数组,再类型转换
    B[] B_arr = (B[]) new Object[10];//行

//  2.静态属性和方法不能使用泛型
//    静态成员属于类,在编译阶段就已经存在了,
//    static A age;
//    public static void info(A aaa){
//        System.out.println(aaa);
//    }

//  3.属性使用泛型
    A a;
    B b;
    C c;
//  4.构造器使用泛型
    public Tiger(String name, A a, B b, C c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }
//  5.普通方法使用泛型，指定返回值类型或参数类型
//  只能使用泛型类中已经声明过的的泛型
    public A getA(A a1) {
        System.out.println(a1.getClass());
        return a1;
    }
    public B getB() {
        return b;
    }
    public C getC() {
        return c;
    }
//  6.泛型方法
//  要求：参数的泛型要和当前泛型类的泛型无关

//  修饰符 <泛型标识符> 返回值类型 方法名(参数){};
//  泛型标识符在 修饰符和返回值类型中间
//  泛型方法的泛型可以是类的泛型，也可以是新的泛型
//  泛型方法中泛型的具体类型是在调用时指出的
//  因此泛型方法可以是静态方法
    public <A,T> void say(A a,T t){
        System.out.println(a.getClass());
        System.out.println(t.getClass());
    }
    public static <X> void x(X x){
        return;
    }
}
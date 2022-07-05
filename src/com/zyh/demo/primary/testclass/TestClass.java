package com.zyh.demo.primary.testclass;

/**
 *
 */
public class TestClass {
    public static void main(String[] args){
//      创建对象：先声明再创建
//      Person01 p1;p1 = new Person01("satomi",33);
//      直接创建
        Person01 p1 = new Person01("zyh",24);
//      访问实例对象的属性
        System.out.println(p1.name+" "+p1.age);
//      调用方法
//      通过类调用静态方法
        Person01.Study();
//      通过对象调用静态方法
        p1.Study();

        p1.cal01(100);
        int[] arr = p1.cal02(5,9);
        System.out.println("两数之差"+arr[0]);
        System.out.println("两数之和"+arr[1]);

    }
}
class Person01{
//  静态字段（类字段）,属于类，类的所有实例共享一个静态字段
    public static String str ="学海无涯";
//  成员变量(属性，全局变量)
    String name;
    int age;
//  构造方法，与类同名，
//  主要作用是完成对象的初始化，可以存在多个构造器，以应对不同情况下对象的初始化
//  无参构造器
    public Person01(){}
//  有参构造器
    public Person01(String name,int Age){
        this.name = name;
        age = Age;
    }


//  成员方法
//  修饰符 返回值 方法名(参数){...}

//  1.静态方法：静态方法就是用 static 修饰的方法，静态方法的调用是通过类名来调用的，也可以通过对象来调用静态方法，但不推荐，因为结果跟对象没有关系。
//  类名.静态方法()
//  静态方法里面没有this和super关键字
//  静态方法只能访问静态成员
//  使用静态方法的情况
//    1.方法不需要访问对象的状态
//    2.方法只需要访问类的静态字段
    public static void Study(){
        System.out.println(str);
    }
//  2.非静态方法：没有 static 修饰的方法，对于非静态方法的调用，是通过对象来调用的
//  对象名.方法()
    public int cal01(int n) {
//      局部变量（实例变量），必须初始化
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
//  一个方法最多有一个返回值，返回值类型包括基本数据类型和引用数据类型(数组，对象)
//  数组作为返回值时可以容纳多个基本数据
    public int[] cal02(int n1,int n2){
        int[] resArr = new int[2];
        resArr[0] = n1+n2;
        resArr[1] = n1-n2;
        return resArr;
        }
}

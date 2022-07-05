package com.zyh.demo.junior.pattern.SingleInstance;

/**
 * 单例设计模式
 * 单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 * 1. 饿汉式，在类加载初始化时就创建好一个静态的对象供外部使用
 *  (1)私有化该类的构造函数
 *  (2)通过new在本类中创建一个本类静态对象
 *  (3)定义一个公有的静态方法(public static classA getA(){return objA})，将在该类中所创建的对象返回
 * 2. 懒汉式，
 *  (1)定义一个静态对象
 *  (2)私有化构造器
 *  (3)定义一个公共的静态方法，返回创建的对象（和饿汉式的方法有细微差别）
 */
public class SingleInstance {
    public static void main(String[] args) {
        System.out.println(Person.n1);//final 和static搭配修饰属性，不会进行类的加载操作
        //100
        System.out.println(Person.n2);//饿汉式，加载类的时候同时创建对象
        //构造器被调用
        //100
        System.out.println(Stu.id);//懒汉式，只有调用创建对象的方法时才创建对象
        //1224
        Stu s1 = Stu.getInstance();//现在才创建对象
        System.out.println(s1);
    }
}
//  单例设计模式-饿汉式
//  只要加载了该类，对象就被创建，可能造成资源浪费
class Person{
    public final static int n1 = 100;
    public static int n2 = 200;

    private String name;
//  1.构造器私有化
    private Person(String name){
        System.out.println("Person类的构造器被调用");
        this.name = name;
    }
//  2.创建static对象
    private static Person p = new Person("zyh");
//  3.定义公共的静态方法访问对象
    public static Person getInstance(){
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
//懒汉式
class Stu{
    public static int id = 1224;
    private String subject;
//  1.定义一个静态对象
    private static Stu stu;
//  2.构造器私有化
    public Stu(String subject){
        System.out.println("Stu类的构造器被调用");
        this.subject = subject;
    }
//  定义一个public static方法访问对象
    public static Stu getInstance(){
        if(stu == null){//如果判断此时还没有创建对象，就创建对象
            System.out.println("Stu创建对象");
            stu = new Stu("java");
        }
        return stu;
    }
}
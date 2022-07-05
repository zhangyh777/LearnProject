package com.zyh.demo.junior.final_keywords;

public class FinalKeywords {
    public static void main(String[] args) {
        System.out.println(Person.score);
        Person person = Person.getInstance();
        System.out.println(Stu.score);//调用了静态属性，但没有使用对象，此时对象还没有创建
        Stu s = Stu.getInstance();//创建对象

    }
}
//饿汉式
class Person{
    private static String name;
    public static double score;
//  1. 构造器私有化
    private Person(String name,double score){
        System.out.println("Person对象已被创建");
        this.name = name;
        this.score = score;
    }
//  2.创建对象
    static Person p = new Person("zyh",90);
//  3.定义public static 方法访问对象
    public static Person getInstance(){
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
class Stu{
    public static double score = 60;
    private String name;
//  定义静态对象
    private static Stu stu;
//  构造器私有化
    private Stu(String name){
        System.out.println("通过构造器初始化对象");
        this.name = name;
    }
//  定义public static方法
    public static Stu getInstance(){
        if(stu==null){

            stu = new Stu("satomi");
            System.out.println("调用getInstance方法创建对象");
        }
        return stu;
    }
}


package com.zyh.demo.primary.test;

public class Test07 {
    public static void main(String[] args){
        Dog d1 = new Dog("cxf","red",25);
        d1.show();
    }
}
class Dog{
    String name;
    String color;
    int age;
    public Dog(String name,String color,int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }
    public void show(){
        System.out.println("具体信息:");
        System.out.print("name:"+name+"\t");
        System.out.print("color:"+color+"\t");
        System.out.print("age:"+age+"\t");



    }

}

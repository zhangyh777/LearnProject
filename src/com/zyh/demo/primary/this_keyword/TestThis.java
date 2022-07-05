package com.zyh.demo.primary.this_keyword;

public class TestThis {
    public static void main(String[] args){
        PersonP p1 = new PersonP("ZYH",24);
        PersonP p2 = new PersonP("satomi",33);
        PersonP p3 = new PersonP("ZYH",24,30000);

        p1.compareTo(p2);
        p1.compareTo(p3);

    }
}
class PersonP{
    String name;
    int age;
    int salary;
//  哪个对象调用，this就指向谁
    public PersonP(String Name,int age){
        name = Name;
        this.age = age;
    }

    public PersonP(String name,int age,int salary){
//  在构造器里面用this语句调用另一个构造器,只能调用一个(this放第一句才有效)
//  this(另一个构造器的形参)
        this(name,age);
        this.salary = salary;

    }
    public void compareTo(PersonP p){
        if((this.name.equals(p.name))&&this.age==p.age){
            System.out.println("两个对象一样");
        }else{
            System.out.println("两个对象不一样");
        }
    }
}



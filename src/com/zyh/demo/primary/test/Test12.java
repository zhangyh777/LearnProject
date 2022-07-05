package com.zyh.demo.primary.test;

public class Test12 {
    public static void main(String[] args){
        Employee e1 = new Employee("zyh",'1',24,"manage",30000);
        Employee e2 = new Employee("satomi",'0',33);
        Employee e3 = new Employee("boss",500000);
        System.out.println(e1.age);

        System.out.println(e2.gender);
        System.out.println(e3.job);

    }
}
class Employee{
    String name;
    String job;
    char gender;
    int age;
    int salary;
    public Employee(String job,int salary){
        this.job = job;
        this.salary = salary;
    }
    public Employee(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public Employee(String name,char gender,int age,String job,int salary){
//      在构造器里面用this语句调用另一个构造器,只能调用一个(this放第一句才有效)
//      this(另一个构造器的形参)
        this(name,gender,age);
        this.job = job;
        this.salary = salary;
    }


}

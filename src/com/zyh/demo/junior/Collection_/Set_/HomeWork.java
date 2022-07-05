package com.zyh.demo.junior.Collection_.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * 1.Employee类，两个私有属性name,age
 * 2.hashSet中存放Employee对象
 *   2.1 属性值完全相同的对象看作重复对象，不添加
 *   2.2 属性值不同的对象才看做新对象
 */
public class HomeWork {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("zyh",24));
        hashSet.add(new Employee("satomi",33));
//      重写了Employee类的hashCode和equals方法之后，只要new出来的对象属性完全相同，它们就是一个对象
        hashSet.add(new Employee("zyh",24));//不会重复添加
        hashSet.add(new Employee("satomi",34));

        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());

        }


    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//  重写Employee对象的equals方法
//  如果两个new出来的Employee对象的属性完全相同,就当作一个对象
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null|| !(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return (this.name==e.name&&this.age==e.age);
    }
//  重写Employee类的hashCode方法
//  ,根据Employee对象的属性来计算,属性完全相同的话hashCode才相同,否则就不同
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

package com.zyh.demo.primary;

public class TestObject {
    public static void main(String[] args) {
        PersonX personX = new PersonX("zyh",24,'男');
        PersonX personX1 = new PersonX("zyh",33,'男');
        System.out.println(personX.equals(personX1));
        System.out.println(personX.toString());
    }
}
class PersonX{
    private String name;
    private int age;
    private char gender;


    public PersonX(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public boolean equals(Object obj) {
//      如果传入的对象和原对象地址相同(同一个对象)，返回true
        if (this == obj) {
            return true;
        }
//      如果传入的对象是PersonX类则进行比较，否则直接返回false
        if(obj instanceof PersonX){
            PersonX p = (PersonX) obj;
            if((this.name).equals(p.name)&&this.age==p.age&&this.gender==p.gender){
                return true;
            }
        }
        return false;
    }
}

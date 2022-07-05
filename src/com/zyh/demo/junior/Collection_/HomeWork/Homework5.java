package com.zyh.demo.junior.Collection_.HomeWork;

import java.util.TreeSet;

public class Homework5 {
    public static void main(String[] args) {
//      TreeSet没传入Comparator匿名对象，默认按照添加对象的compareTo方法实现去重
//      但Person类没有实现Comparable接口，也就没有compareTo方法，报错
//      让Person实现Comparable接口，并重写compareTo方法
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person());
        treeSet.add(new Person());
        treeSet.add(new Person());
        System.out.println(treeSet);
    }
}
class Person implements Comparable{

    public Person() {
    }
    @Override
    public int compareTo(Object o){
        return o.hashCode();
    }
}

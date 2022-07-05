package com.zyh.demo.junior.Collection_.Set_;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Employee类：private String name,double sal,MyDate birthday(包括year,month,day)
 * 1.创建三个Employee对象放入hashSet
 * 2.name和birthday相同时认为是相同对象，不能重复添加
 */
public class HomeWork1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        MyDate myDate = new MyDate(1998,12,24);
        MyDate myDate1 = new MyDate(2000,2,15);
        MyDate myDate2 = new MyDate(1998,12,24);


        hashSet.add(new E("zyh",3000,myDate));
        hashSet.add(new E("satomi",3000,myDate1));
        hashSet.add(new E("zyh",3000,myDate2));

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
class E{
    private String name;
    private double sal;
    private MyDate birthday;

    public E(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E e = (E) o;
        return name.equals(e.name) && birthday.equals(e.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return  getClass().getName()+"{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDate)) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
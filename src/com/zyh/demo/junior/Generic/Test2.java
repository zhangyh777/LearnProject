package com.zyh.demo.junior.Generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1.Employee类，私有属性：String name，double sal，MyDate birthday
 * 2.创建ArrayList（使用泛型），存放Employee对象
 * 3.对ArrayList传入匿名对象进行自定义排序：
 *   3.1.名字不同的话就按名字排序
 *   3.2.名字相同的话按birthday排序， year->month->day
 */
public class Test2 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(2000,11,11);
        MyDate myDate2 = new MyDate(2001,12,12);
        MyDate myDate3 = new MyDate(1980,10,10);

        Employee employee1 = new Employee("zyh",10000,myDate1);
        Employee employee2 = new Employee("zyh",6000,myDate2);
        Employee employee3 = new Employee("zyh",5000,myDate3);
        ArrayList<Employee> employees = new ArrayList();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println("===遍历原List===");
        for (Employee e:employees
             ) {
            System.out.println(e);
        }

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

//              比较名字是否相同，相同的话返回0，不相同的话返回其他值
                int i = o1.getName().compareTo(o2.getName());
                if(i==0){//name相同，执行MyDate的compareTo方法依次比较year-month-day
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }
//              name不相同，按name排序
                return i;
            }
        });
/**
 * 把birthday的比较封装到MyDate类中，
 * MyDate类需要实现Comparable接口（MyDate泛型），重写compareTo方法对MyDate对象进行比较
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//              按名字比较，名字相同的话就返回0，不同的话就返回其他值
                int i = o1.getName().compareTo(o2.getName());
                if (i!=0){//名字不同
                    return i;
                }
//              名字相同，按birthday比较
                int year = o1.getBirthday().getYear()-o2.getBirthday().getYear();
                int month = o1.getBirthday().getMonth()-o2.getBirthday().getMonth();
                int day = o1.getBirthday().getDay()-o2.getBirthday().getDay();
                if(year!=0){//year不同
                    return year;
                }
                if(month!=0){//month不同
                    return month;
                }
//              year和month都相同，按day比较
                return day;
            }
        });
 */
        System.out.println("===排序后的List===");
        for (Employee e:employees
        ) {
            System.out.println(e);
        }
    }
}
class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
//MyDate实现Comparable接口，
// 使用MyDate泛型，重写compareTo方法对MyDate对象进行比较
class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }
    @Override
    public int compareTo(MyDate o){
        int year = this.year - o.getYear();
        int month = this.month - o.getMonth();
        int day = this.day - o.getDay();
        if(year!=0){
            return year;
        }
        if(month!=0){
            return month;
        }
        return day;
    }
}
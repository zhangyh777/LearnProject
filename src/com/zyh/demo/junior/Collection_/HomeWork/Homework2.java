package com.zyh.demo.junior.Collection_.HomeWork;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 使用ArrayList完成对对象Car {name, price}的各种操作
 * 1.add:添加单个元素
 * 2.remove:删除指定元素
 * 3.contains:查找元素是否存在
 * 4.size:获取元素个数
 * 5.isEmpty:判断是否为空
 * 6.clear:清空
 * 7.addAll:添加多个元素
 * 8.containsAll:查找多个元素是否都存在
 * 9.removeAll:删除多个元素
 * 使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
 *  * Car car1 = new Car(“宝马",400000);
 *  * Car car2 = new Car("宾利"，5000000);
 */
public class Homework2 {
    public static void main(String[] args) {
         Car car1 = new Car("宝马",400000);
         Car car2 = new Car("宾利",5000000);
        ArrayList list = new ArrayList();
        list.add(car1);
        list.add(car2);
        System.out.println(list);

        list.remove(car1);
        System.out.println(list);

        System.out.println(list.contains(car1));//false

        System.out.println(list.size());//1

        System.out.println(list.isEmpty());//false

        ArrayList list1 = new ArrayList();
        list1.add("a");
        list1.add("bb");
        list.addAll(0,list1);
        System.out.println(list);
        System.out.println("===foreach===");
        for (Object obj: list){
            System.out.println(obj);
        }
        System.out.println("===迭代器===");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(list.containsAll(list1));//true
        list.removeAll(list1);
        System.out.println(list);




    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

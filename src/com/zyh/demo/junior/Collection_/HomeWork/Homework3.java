package com.zyh.demo.junior.Collection_.HomeWork;

import java.util.*;

/**
 * 按要求系成下列任务
 * 1)使用HashMap类实例化一个Map类型的对象m，键(String)和值(int)分别用于存储员工的姓名和工资，存入数据如下:jack—650元; tom—1200元; smith——2900元;
 * 2)将jack的工资更改为2600元
 * 3)为所有员工工资加薪100元;
 * 4)遍历集合中所有的员工
 * 5)遍历集合中所有的工资
 */
public class Homework3 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);

        System.out.println(hashMap);
        hashMap.put("jack", 2600);
        System.out.println(hashMap);
//      keySet方法获取的是hashMap的key的集合,hashMap.get(key)获取的才是value
        Set keyset = hashMap.keySet();
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            var key = iterator.next();
//          hashMap的key-value中，key和value都是Object类型，不能+运算，向下转型
            Integer i = (Integer) hashMap.get(key);
            i += 100;
            hashMap.put(key, i);
        }
        System.out.println(hashMap);

        for (Object key : keyset
        ) {
            Integer i = (Integer) hashMap.get(key);
            i += 100;
            hashMap.put(key, i);
        }
        System.out.println(hashMap);
//      entrySet方法获取的是key-value存储的集合
//      向下转型为 Map.Entry,getKey和getValue可以分别获得key和value,此时key和value都还是Object对象
        Set entryset = hashMap.entrySet();
        for (Object obj : entryset
        ) {
            System.out.println(obj);
        }
        for (Object obj:entryset
             ) {
            Map.Entry m = (Map.Entry) obj;
            Integer i = (Integer) m.getValue();
            i += 100;
            hashMap.put((m.getKey()),i);
        }
        System.out.println(hashMap);


    }
}

class Worker {
    private String name;
    private double sal;

    public Worker(String name, double sal) {
        this.name = name;
        this.sal = sal;
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
}


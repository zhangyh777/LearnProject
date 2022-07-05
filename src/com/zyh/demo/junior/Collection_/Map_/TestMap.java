package com.zyh.demo.junior.Collection_.Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1998,new Worker("zyh",1998,30000));
        hashMap.put(1999,new Worker("zjh",1999,20000));
        hashMap.put(1987,new Worker("satomi",1987,300000));
        hashMap.put(2000,new Worker("aaa",2000,10000));
//      keySet方法+迭代器
        System.out.println("keySet方法+迭代器");
        Set keyset = hashMap.keySet();
        Iterator iterator = keyset.iterator();
        while(iterator.hasNext()){

            var key = iterator.next();
            Object obj = hashMap.get(key);
            Worker t = (Worker) obj;
            if(t.getSal()>18000){
                System.out.println(t);
            }
        }
//      keySet方法+foreach
        System.out.println("keySet方法+foreach");
        for (Object key: keyset
             ) {
            Object v = hashMap.get(key);
            Worker worker = (Worker) v;
            if(worker.getSal()>18000){
                System.out.println(worker);
            }
        }
//      entrySet+迭代器
        System.out.println("entrySet方法");
        Set entryset = hashMap.entrySet();
        Iterator iterator1 = entryset.iterator();
        while(iterator1.hasNext()){
            Map.Entry m = (Map.Entry) iterator1.next();
//          getSal方法在Worker对象中，即 m.getValue的返回值，向下转型
            Worker w = (Worker) m.getValue();
            if(w.getSal()>18000){
                System.out.println(w);
            }
        }



    }
}
class Worker{
    private String name;
    private int id;
    private double sal;

    public Worker(String name, int id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sal=" + sal +
                '}';
    }
}

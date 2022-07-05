package com.zyh.demo.junior.Generic;


import java.util.*;


public class Test {
    public static void main(String[] args) {
        HashSet<Stu> stuHashSet = new HashSet<Stu>();
        Stu<String,Integer> stringStu1 = new Stu<String,Integer>("zyh",24);
        Stu<String,Integer> stringStu2 = new Stu<String,Integer>("satomi",33);
        Stu<String,Integer> stringStu3 = new Stu<String,Integer>("aaa",18);
        stuHashSet.add(stringStu1);
        stuHashSet.add(stringStu2);
        stuHashSet.add(stringStu3);
        for (Stu s:stuHashSet
             ) {
            System.out.println(s.toString());
        }


//      HashMap构造器中传入两个泛型，一个为key的类型，一个为value的类型
        HashMap<String,Stu> stuHashMap = new HashMap<String,Stu>();
        stuHashMap.put(stringStu1.getName(),stringStu1);
        stuHashMap.put(stringStu2.getName(),stringStu2);
        stuHashMap.put(stringStu3.getName(),stringStu3);
//      keySet先遍历key，再get(key)获取value
        System.out.println("===keySet遍历===");
        Set<String> strings = stuHashMap.keySet();
        for (String s:strings
             ) {
            System.out.println(s+"-"+stuHashMap.get(s));
        }

//      entrySet结合Iterator或者foreach遍历key-value
        Set<Map.Entry<String, Stu>> entries = stuHashMap.entrySet();
        System.out.println("===entrySet+Iterator===");
        Iterator<Map.Entry<String, Stu>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Stu> next = iterator.next();
            System.out.println(next.getKey()+"-"+next.getValue());
        }
        System.out.println("===entrySet+foreach===");
        for (Map.Entry<String,Stu> s: entries) {

            System.out.println(s.getKey()+"-"+s.getValue());
        }
//      values遍历value，不能遍历key
        System.out.println("===values遍历value===");
        Collection<Stu> values1 = stuHashMap.values();
        for(Stu stu:values1){
            System.out.println(stu);
        }

    }
}

class Stu<E,I>{
    private E name;
    private I age;

    public Stu(E name,I age) {
        this.name = name;
        this.age = age;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public I getAge() {
        return age;
    }

    public void setAge(I age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}

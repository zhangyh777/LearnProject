package com.zyh.demo.junior.Collection_.Map_;


import java.util.*;

/**
 * Map,双列集合
 * 1.无序
 * 2.key可以是任何类型，不能重复（重复的话会替换value），可以为null（只能有一个）,
 *   value可以是任何类型,可以重复（也可以有多个null）
 * remove,根据key或者key-value删除元素
 * get,根据key获得元素
 * size,获取元素个数
 * isEmpty,判断是否为空
 * clear,清空
 * containsKey,判断key是否存在
 *
 *  Map遍历
 *  1）.containsKey查找key是否存在,
 *  2）.keySet获取送有的key,返回值一个Set
 *  3）.entrySet获取所有key-value,返回值为一个Set
 *  4).values获取所有的value,返回值为一个Collection
 *
 *  实现Map接口的常用类：HashMap,Hashtable,Properties
 *  HashMap线程不安全,Hashtable线程安全
 */
public class Map_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no.1","zyh");//k-v
        map.put("no.2","satomi");//k-v
        map.put("no.3","satomi");//k-v,value可以重复
        map.put("no.3","zyh");//key重复，把value替换掉

        System.out.println(map);
        System.out.println(map.get("no.1"));

//      遍历
//      1.keySet方法
//      1)先取出key，2)再根据key取出value
//      keySet获取Map对象的所有key，返回值为集合
        System.out.println("===keySet方法===");
        Set keyset = map.keySet();
        Iterator iterator = keyset.iterator();
        while(iterator.hasNext()){
//          取出key
            var key = iterator.next();
//          get方法根据key取出value
            System.out.println(key+"-"+map.get(key));
        }
//      2.values方法
//      只能取出value,无法获得key
        System.out.println("===values方法===");
        Collection valueSet = map.values();
        for (Object obj:valueSet) {
            System.out.println(obj);
        }
//      3.entrySet方法
//      Map.Entry类提供getKey和getValue方法分别获得key和value
        System.out.println("===entrySet方法===");
        Set entryset = map.entrySet();
        for (Object obj:entryset
             ) {
            System.out.println(obj);
        }
        System.out.println("Map.Entry类的get方法");
        for (Object obj:entryset
             ) {
//          向下转型，Map.Entry类提供了getKey和getValue方法
            Map.Entry m = (Map.Entry) obj;
            System.out.println(m.getKey()+"->"+m.getValue());
        }

    }

}

package com.zyh.demo.junior.Collection_.Map_;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 *
 */
public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//              按字符串长度排序
                return ((String) o1).length()-((String) o2).length();
            }
        });
        treeMap.put("zyh",24);
        treeMap.put("a",32);
        treeMap.put("bb",12);
        treeMap.put("dddd",14);
        System.out.println(treeMap);
//      新传入的key-value的key长度和treeMap中zyh-24的key长度一样，
//      重复key，替换value
        treeMap.put("ccc",0);
        System.out.println(treeMap);//[a=32,bb=12,zyh=0,dddd=14]

    }
}

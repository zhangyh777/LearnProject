package com.zyh.demo.junior.Collection_.Map_;

import java.util.Hashtable;

/**
 * Hashtable和HashMap都是Map接口的实现类，同级关系
 * Hashtable从jdk1.0出现,HashMap从jdk1.2出现
 * 1.key-value形式存放数据
 * 2.key和value都不能为null
 * 3.初始容量大小为 11 ,加载因子为3/4
 * 4.线程安全的
 * 使用方法和HashMap基本一样
 * 扩容机制：
 * 初始容量为11，临界值为8，
 * 元素个数>=临界值，需要扩容
 * 扩容规则：容量 * 2 + 1
 */
public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < 17; i++) {
            hashtable.put(i,"hello"+i);
        }
    }
}

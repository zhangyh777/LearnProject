package com.zyh.demo.junior.Collection_.Set_;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LinkedHashSet是HashSet的子类,
 * 底层是一LinkedHashMap,数组+双向链表
 * 和HashSet一样也不允许加入重复元素,但保证了顺序
 */
public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Set set = new HashSet();

        linkedHashSet.add("zyh");
        linkedHashSet.add(1224);
        linkedHashSet.add("satomi");
        linkedHashSet.add("satomi");

        set.add(1);
        set.add("a");
        set.add(4);
        set.add("b");
        set.add('c');
        set.add("hhh");

        System.out.println("LinkedHashSet遍历取出顺序和添加顺序保持一致:");
        System.out.println(linkedHashSet);
        for (Object o:linkedHashSet
             ) {
            System.out.println(o);
        }
        System.out.println("HashSet遍历取出顺序和添加顺序无关:");
        System.out.println(set);
        for (Object o:set
             ) {
            System.out.println(o);
        }
    }
}

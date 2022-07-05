package com.zyh.demo.junior.Collection_.List_;

import java.util.LinkedList;

/**
 * 链表不支持快速随机访问，即链表的访问都是从头开始的，即使是get方法，只是“虚假”的随机访问
 * add，默认在尾部添加元素，可以指定索引
 * remove,默认删除第一个元素，可以指定索引或者指定元素
 * addAll
 * set
 * get
 * indexOf
 * lastIndexOf
 * contains
 * clear
 * size
 * toArray,返回一个由链表元素组成的数组
 * 对首尾元素快捷操作：
 * addFirst
 * addLast
 * removeFirst
 * removeLast
 * getFirst
 * getLast
 *
 */
public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add('a');
        linkedList.add("zyh");
        linkedList.add("satomi");
        System.out.println("linkedList= "+linkedList);
        System.out.println(linkedList.get(1));
        linkedList.remove();
        System.out.println("remove默认删除第一个元素");
        System.out.println(linkedList);
    }
}

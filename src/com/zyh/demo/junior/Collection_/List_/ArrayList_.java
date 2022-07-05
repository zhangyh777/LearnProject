package com.zyh.demo.junior.Collection_.List_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List接口
 * 实现了List接口的类（常用）
 * 1.ArrayList（线程不安全，多线程不建议使用）
 * 2.LinkedList（线程不安全）
 * 3.Vector（线程安全,即方法带有synchronized修饰）
 *
 * ArrayList和LinkedList选择
 * 增删的操作多的话，用LinkedList
 * 改查的操作多的话，用ArrayList
 *
 * List集合类中元素有序（添加顺序和取出顺序一致），且元素可重复
 * List集合中的每个元素都有其对应的索引，即支持索引访问（随机访问）
 * List扩容机制：capacity
 *  1.无参构造器创建List时
 *  初始容量为0，第一次添加元素时扩容为10，如需要再次扩容，则扩容为1.5倍
 *  2.有参构造器创建List时
 *  初始容量为指定大小，需要扩容时，扩容为1.5倍
 *
 * 常用方法：
 * add(index,obj),在指定索引位置加入元素
 * addAll(index,Collection)，从指定索引位置开始把集合中的元素加进去
 * indexOf(obj),返回指定元素在集合中第一次出现的索引，如果不存在则返回-1
 * lastIndexOf(obj),返回指定元素在集合中最后一次出现的索引
 * remove(index),删除指定索引位置上的元素
 * set(index,new_obj),将指定索引位置上的元素替换为new_obj
 * subList(start,end),以集合形式返回[start,end)范围内的元素
 * contains(),判断元素是否在List中
 * iterator(),迭代器,用于遍历访问元素

 */
public class ArrayList_ {
    public static void main(String[] args) {
        List list = new ArrayList();
//      add,List接口下的类允许重复元素
        list.add("aaa");
        list.add("aaa");
        list.add("ccc");
        System.out.println(list);
//      get,根据索引获取元素
        System.out.println(list.get(0));
//      add(index,elements),在指定索引位置添加元素
        list.add(2,"bbb");
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("ddd");
        list1.add("EEE");
//      addAll,add(index,Collection),添加实现了Collection接口的集合
        list.addAll(2,list1);
        System.out.println(list);
//      subList(start,end),获取[start,end)范围内的元素
        System.out.println(list.subList(0,2));
//      set(index,new_obj),修改指定索引位置上的元素
        list.set(2,"new_obj");
        System.out.println(list);
//      indexOf,lastIndexOf
        System.out.println(list.indexOf("aaa"));//0
        System.out.println(list.indexOf("A"));//-1
        System.out.println(list.lastIndexOf("aaa"));//1

//      遍历集合中的元素
//      1.foreach
//      2.iterator
        System.out.println("foreach循环遍历:");
        for (Object o:list
             ) {
            System.out.println(o);
        }
        System.out.println("iterator迭代器遍历:");
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        /*
                listIterator迭代器
                迭代的同时能够对List进行修改
                hasNext()和next()方法和iterator迭代器的一样
                额外有hasPrevious()和previous()方法能对List进行反向遍历
         */
        System.out.println("listIterator迭代器:");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            if (listIterator.next().equals("new_obj")){
                listIterator.add("NEW_OBJ");
            }
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }
}

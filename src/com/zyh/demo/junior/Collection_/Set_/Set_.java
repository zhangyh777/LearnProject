package com.zyh.demo.junior.Collection_.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set接口
 * 1.无序（添加和取出的顺序不一致），但取出顺序固定，且不支持索引
 * 2.不允许重复元素,只允许一个null
 *
 * 常用方法：Set和List一样，都是Collection的子接口，常用方法和Collection一样
 * 实现Set接口的类
 * 1.TreeSet（有序）
 * 2.HashSet（无序）
 *   HashSet还有一个常用子类LinkedHashSet,和HashSet不一样的是它保证了顺序
 *   HashSet底层实际上是HashMap
 *   源码：
 *       public HashSet() {
 *         map = new HashMap<>();
 *     }
 *
 */
public class Set_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("zyh");
        hashSet.add('A');
        hashSet.add(1224);
        hashSet.add(1224);//重复的元素不会被添加
//      因为都是new出来的对象，两者只是属性相同，但却不是相同的对象，可以重复添加
        hashSet.add(new A("AAA"));//添加成功
        hashSet.add(new A("AAA"));//添加成功

        hashSet.add(new String("bbb"));//添加成功
        hashSet.add(new String("bbb"));//添加失败


        hashSet.add(null);
        hashSet.add(null);//hashSet里只会有一个null
//      无序，取出顺序和添加顺序不一致，但取出顺序是固定的
//      （List的实现类是有序的，取出和添加顺序一致）
        System.out.println(hashSet);
        System.out.println(hashSet);
//      遍历，两种方式，1.迭代器   2.foreach
        System.out.println("===迭代器遍历===");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===foreach遍历===");
        for (Object e:hashSet
             ) {
            System.out.println(e);
        }


    }
}
class A{
    private String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}

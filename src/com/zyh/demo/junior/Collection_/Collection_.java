package com.zyh.demo.junior.Collection_;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * 集合Collection
 * 任何对象加入集合类后，自动转变为Object类型，所以在取出的时候，需要进行强制类型转换。
 * 1.单列集合（List,Set）
 * List
 *   1.Vector
 *   2.ArrayList
 *   3.LinkedList
 * Set
 *   1.HashSet
 *     1.1 LinkedHashSet
 *   2.TreeSet
 *

 * 2.双列集合（Map）
 * Map
 *   1.HashMap
 *     1.1 LinkedHashMap
 *   2.TreeMap
 *   3.Hashtable
 *   4.Properties
 *
 *
 * 集合的常用方法
 * add
 * remove
 * contains
 * size
 * isEmpty
 * clear
 * addAll
 * containsAll
 * removeAll
 * 拿ArrayList来操作
 */
public class Collection_ {
    public static void main(String[] args) {

//      add：添加单个元素
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList();

        arrayList.add("zyh");
        arrayList.add(1);
        arrayList.add(true);
        arrayList.add("ig");
        arrayList.add("edg");

        arrayList1.add("三国演义");
        arrayList1.add("红楼梦");
        arrayList1.add("水浒传");

        System.out.println("arrayList="+arrayList);
//      remove，删除指定元素，按索引删除或者按元素删除
//      删除指定索引位置的元素,索引不能超出范围
        arrayList.remove(1);
        System.out.println("arrayList="+arrayList);
//      删除指定元素,指定元素不存在也可
        arrayList.remove("zyh");
        System.out.println("arrayList="+arrayList);
        arrayList.remove("satomi");
        System.out.println("arrayList="+arrayList);
//      contains：判断指定元素是否存在
        boolean bool = arrayList.contains("edg");//true
        System.out.println(bool);
//      size：返回集合的大小
        int num = arrayList.size();
        System.out.println(num);
//      isEmpty：判断集合是否为空
        boolean bool1 = arrayList.isEmpty();//false
        System.out.println(bool1);
//      clear：清空集合
        arrayList.clear();
        System.out.println(arrayList);//[]
//      将集合添加到集合中去
        arrayList.addAll(arrayList1);
        System.out.println(arrayList);
//      containsAll：判断多个元素是否同时存在
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("三国演义");
        arrayList2.add("红楼梦");

        boolean bool2 = arrayList.containsAll(arrayList2);//true
        System.out.println(bool2);
//      removeAll：删除多个元素
        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);//[水浒传]

//      遍历集合
//      1.iterator方法
//      凡是集合，都有iterator方法
//      hasNext()方法，判断集合是否有元素，
//      next()方法，获取元素，每次取一个，可放在循环中，如果集合中没有元素的话会报错
        ArrayList list = new ArrayList();
        list.add(new Book("三国演义","罗贯中",25.6));
        list.add(new Book("西游记","吴承恩",15.6));
        list.add(new Book("红楼梦","曹雪芹",35));
        list.add("zyh");
//      集合迭代器
        Iterator iterator = list.iterator();

        while(iterator.hasNext()){//集合中存在元素的话
            Object obj = iterator.next();//迭代取出集合中的元素
            System.out.println("obj= "+obj);
        }
//      iterator.next();//集合中没有元素了，进行迭代会报错
//      重置迭代器
        iterator = list.iterator();
        System.out.println(iterator.next());

//      for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

//      2.foreach循环
        for (Object obj: list
             ) {
            System.out.println(obj);
        }

    }

}
class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

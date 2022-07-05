package com.zyh.demo.junior.Collection_.Set_;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

/**
 * TreeSet
 * TreeSet即使不使用泛型限定,其内部元素也要求是同一类型（实现了Comparable接口的类型）
 * Set接口的实现类,和HashSet并列关系
 * HashSet唯一，无序
 * TreeSet有序（自定义比较规则），不一定唯一（要根据比较规则来确定）
 *
 * TreeSet底层是二叉树，可以对对象元素进行排序，但是自定义类需要实现comparable接口，重写comparaTo() 方法。
 * TreeSet 可以保存对象元素的唯一性（并不是一定保证唯一性，需要根据重写的compaaTo方法来确定）
 *
 * 排序规则
 * 1.通过TreeSet里的对象的compareTo方法定义
 * 2.或者创建TreeSet时传入实现了Comparator接口的匿名内部类来定义比较规则
 * 在使用自然排序时只能向 TreeSet 集合中添加相同数据类型的对象，否则会抛出 ClassCastException 异常。
 * 如果向 TreeSet 集合中添加了一个 Double 类型的对象，则后面只能添加 Double 对象，不能再添加其他类型的对象，例如 String 对象等。
 */
public class TreeSet_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
//      使用无参构造器创建TreeSet时，如果Set内部中的元素是java中的原生类，使用该类的compareTo方法（也可以重写）
//      如果Set内元素是自定义类型,要求自定义类型要实现Comparable接口或者自定义一个实现了Comparator接口的类
//      且要求数据类型一致
        TreeSet treeSet = new TreeSet();
        treeSet.add("alice");
        treeSet.add("zyh");
        treeSet.add("bob");
//        treeSet.add('c');//不能添加非String类型的数据了

        System.out.println(treeSet);//[alice,bob,zyh]
//      1.匿名内部类的方式定义比较规则
//      按元素长度排序
        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length()-((String) o2).length();
            }
        });
        treeSet1.add("qe");
        treeSet1.add("edc");
        treeSet1.add("f");
        treeSet1.add("hhhh");
//      无法添加进去，因为比较规则为元素长度，treeSet1中已经存在长度为3的元素，
//      只要新添加的元素长度为3，无论内容是什么，都视为和"edc"是重复元素，无法添加
        treeSet1.add("zyh");
        System.out.println(treeSet1);//[f,qe,edc,hhhh]

//      2.外部比较类的方式定义比较规则
        OutCompare outCompare = new OutCompare();
        TreeSet treeSet2 = new TreeSet(outCompare);
        treeSet2.add("aabb");
        treeSet2.add("aa");
        treeSet2.add("aabc");
        treeSet2.add("aabc");//根据比较规则,treeSet2中已经有了一个"aabc",无法添加
        System.out.println(treeSet2);



    }
}
/*
    外部比较器
    比较规则：String的compareTo方法一样（先比较长度，长度不一样直接返回长度差，长度一样的话逐个比较字符）
 */
class OutCompare implements Comparator{
    @Override
    public int compare(Object o1,Object o2){
        return ((String) o1).compareTo((String) o2);
    }
}

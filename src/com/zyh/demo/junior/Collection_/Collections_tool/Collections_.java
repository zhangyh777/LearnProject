package com.zyh.demo.junior.Collection_.Collections_tool;

import java.util.*;

/**
 * Collections工具类
 * 提供一系列静态方法来对集合进行操作
 * 1.对List进行操作的方法
 *  1.Collections.sort(List),自然排序，因为排序会改变元素的位置，因此要传入可变List
 *  2.Collections.sort(List,new Comparator{...}),传入匿名内部类，定制排序
 *  3.Collections.shuffle(List),洗牌，随机打乱List元素顺序，相当于洗牌
 *  4.Collections.reverse(List),翻转List
 *  5.Collections.swap(List,int i,int j),交换索引i,j位置上的元素
 *  6.Collections.copy(List dest,List src),将src中的内容复制大dest中，首先需要给dest赋值，不能让dest为null，dest长度和src一样
 *  7.Collections.replaceAll(List,Object old,Object new),用new值替换old值
 * 2.对集合进行操作的方法
 *  1.Collections.max(Collection),返回自然排序之后最大的元素
 *  2.Collections.max(Collection,new Comparator{...})
 *  3.Collections.min(Collection)
 *  4.Collections.min(Collection,new Comparator{...})
 */
public class Collections_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        //一次性添加多个元素
        Collections.addAll(list,"bbbbbb","ccc","dddd","zhang");
//      自然排序
        System.out.println("===自然排序===");
        Collections.sort(list);
        System.out.println(list);
//      按字符串长度排序
        System.out.println("===按字符串长度排序===");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).length()-((String)o2).length();
            }
        });
        System.out.println(list);
//      翻转
        System.out.println("===翻转===");
        Collections.reverse(list);
        System.out.println(list);
//      洗牌
        System.out.println("===洗牌五次===");
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println(list);
        }
//      交换位置
        System.out.println("===交换位置===");
        Collections.swap(list,0,1);
        System.out.println(list);
//      自然排序值最大的元素
        var v = Collections.max(list);
        System.out.println(v);
//      自定义排序值最大的元素
        var v1 = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1,Object o2){
              return ((String)o1).length()-((String)o2).length();
            }
        });
        System.out.println(v1);

    }
}

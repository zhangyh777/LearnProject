package com.zyh.demo.junior.CommonlyUsedClass.ArraysClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays包含一系列静态方法，用以对数组进行操作
 * 1.toString（返回数组的字符串形式）
 * 2.sort（自然排序和定制排序）,原数组的实际顺序会发生变化
 * 3.binarySearch（二分查找，要求数组必须排好序）
 * 4.copyOf(arr,n)，从arr数组拷贝n个元素到新数组去，短了拷贝所有，长了0填充
 * 5.fill(arr,num),用num填充arr数组
 * 6.asList(arr),将数组arr转换为List
 *
 *
 */
public class ArraysClass {
    public static void main(String[] args) {
        String[] s1 = {"java","python","cpp","html"};
//      Arrays.toString(arr)
        System.out.println(s1);
        String s2 = Arrays.toString(s1);
        System.out.println(s2);
//      Arrays.sort()
//      1.自然升序排序    Arrays.sort(arr)
        int[] i1 = {5,-6,1,3,-7,9};
        Arrays.sort(i1);//原数组顺序发生变化
        System.out.println(Arrays.toString(i1));
//      2.指定区间内排序  Arrays.sort(arr,start,end)
        double[] D1 = {1.2,-3.1,2.5,0.5,6.7,0.6};
        Arrays.sort(D1,0,3);
        System.out.println(Arrays.toString(D1));
//      3.定制排序
//      传入两个参数：1.目标数组 2.实现了Comparator接口的匿名内部类
        Integer[] I2 = {2,-6,9,7,-1};
        Arrays.sort(I2, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer a = (Integer) o1;
                Integer b = (Integer) o2;
                return a-b;
            }
        });
        System.out.println(Arrays.toString(I2));
//      4.binarySearch()
//      在i1数组中查找"3",返回索引
//      如果不存在，则返回 -（index+1），index=如果存在该元素，该元素在数组中的索引
        int index = Arrays.binarySearch(i1,3);
//      {-7,-6,1,3,5,9},2不在数组中，如果存在则应该排在索引为3的位置上
        int i = Arrays.binarySearch(i1,2);//-（3+1）= -4
        System.out.println("index= "+index);
        System.out.println("i= "+i);
//      copyOf
        int[] i3 = Arrays.copyOf(i1,4);
        System.out.println(Arrays.toString(i3));
//      fill
        Arrays.fill(i3,0);
        System.out.println(Arrays.toString(i3));


    }
}

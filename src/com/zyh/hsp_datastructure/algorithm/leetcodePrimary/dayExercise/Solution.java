package com.zyh.hsp_datastructure.algorithm.leetcodePrimary.dayExercise;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
//        String s = "bbbcccdddaaa";
//        System.out.println(Arrays.toString(numberOfLines(widths, s)));

        RandomizedSet set = new RandomizedSet();
        System.out.println(set.getRandom());
        System.out.println(set.insert(1));
        System.out.println(set.getRandom());

        System.out.println(set.remove(2));


    }


    public static int[] numberOfLines(int[] widths, String s) {
        //ans[0]是总行数,最少为1
        //ans[1]是最后一行占用的宽度,最少为0
        int[] ans = new int[2];
        ans[0] = 1;
        for (char arr : s.toCharArray()) {
            //widths[arr-'a']是遍历到的字符占用的宽度,累加
            ans[1] += widths[arr - 'a'];
            //如果遍历到的字符累计占用的宽度超过100,那么要另起一行（即ans[0]++）,同时最后一行占用的宽度要更新为新字符占用的宽度（即ans[1]=widths[arr-'a']）
            if (ans[1] > 100) {
                ans[1] = widths[arr - 'a'];
                ans[0]++;
            }
        }
        return ans;
    }
}

class RandomizedSet {

    /*
            RandomizedSet() 初始化 RandomizedSet 对象
            bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
            bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
            int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     */

    HashSet<Integer> set;
    ArrayList<Integer> list;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean flag = set.add(val);
        if (flag) list.add(val);
        return flag;
    }

    public boolean remove(int val) {
        boolean flag = set.remove(val);
        if (flag) list.remove(val);
        return flag;
    }

    //随机获取
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }


}

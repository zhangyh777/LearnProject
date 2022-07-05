package com.zyh.hsp_datastructure.algorithm.Greedy;

import java.util.*;

/**
 * 贪心算法：每一次都选取最优结果，从而使得最终结果是最优的
 * 但可能是局部最优解
 * 广播电台K1,K2K3,K4,K5,每个电台都有各自的覆盖地区,如何选用最少的电台使得覆盖地区最多
 * K1   北京  上海  天津
 * K2   广州  北京  深圳
 * K3   成都  上海  杭州
 * K4   上海  天津
 * K5   杭州  大连
 */
public class Test {
    public static void main(String[] args) {
        //HashMap存放电台及其覆盖地区
        //K1-[北京,上海,天津]
        HashMap<String, HashSet<String>> FM_Areas = new HashMap<>();
        //HashSet存放每个电台的覆盖地区
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        HashSet<String> set2 = new HashSet<>();
        set2.add("北京");
        set2.add("广州");
        set2.add("深圳");
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        FM_Areas.put("FM1", set1);
        FM_Areas.put("FM2", set2);
        FM_Areas.put("FM3", set3);
        FM_Areas.put("FM4", set4);
        FM_Areas.put("FM5", set5);


        //HashSet存放所有地区（不重复）
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(set1);
        allAreas.addAll(set2);
        allAreas.addAll(set3);
        allAreas.addAll(set4);
        allAreas.addAll(set5);

        //存放每一次选择的电台
        List<String> FMlist = new ArrayList<>();

        //临时HashSet存放 每次遍历时当前电台所覆盖的地区 和 总地区中还没有被覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();
        //maxKey存放每次遍历过程中能够覆盖到最大未覆盖地区的电台
        String maxKey = null;
        while (!allAreas.isEmpty()) {//选择的电台还没把所有地区覆盖完
            //！！！
            //每次找到一个最优电台后,最优电台的标志要置空,重新找下一个最优电台
            maxKey=null;
            for (String key : FM_Areas.keySet()//key:FM1,FM2,FM3,FM4,FM5
            ) {
                //！！！
                //
                tempSet.clear();
                //当前电台能覆盖的地区
                HashSet<String> areas = FM_Areas.get(key);
                //当前电台覆盖到的地区放到临时集合中
                tempSet.addAll(areas);
                //当前电台能覆盖到的地区和所有未覆盖地区的交集,赋给临时集合
                tempSet.retainAll(allAreas);

                //贪心算法,每次选择覆盖最多地区的电台
                if (!tempSet.isEmpty() &&
                        (maxKey == null || tempSet.size() > FM_Areas.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //
            if (maxKey!=null){
                //把选择的电台放到结果List中
                FMlist.add(maxKey);
                //把选择的电台所覆盖的地区从所有地区中删除
                allAreas.removeAll(FM_Areas.get(maxKey));
            }

        }

        Iterator it = FMlist.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

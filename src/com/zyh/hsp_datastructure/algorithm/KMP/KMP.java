package com.zyh.hsp_datastructure.algorithm.KMP;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {

        String s = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDABD";
        int[] next = kmpNext(target);
        System.out.println("next数组=" + Arrays.toString(next));
        int index = kmpSearch(s, target);
        System.out.println("index=" + index);

    }


    /**
     * @param s      源字符串
     * @param target 子串
     * @return
     */
    public static int kmpSearch(String s, String target) {
        int[] next = kmpNext(target);

        //i指向源字符串
        //j指向子串
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != target.charAt(j)) {
                j = next[j - 1];//不匹配的话j指针回溯
            }
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /*
        //kmp算法的next数组
        //最大公共元素长度
        //长度为N的字符串分割成N个子串,str0,str01,str012,,,,
        //找出每个子串的前缀和后缀
        //计算每个子串的前缀和后缀的公共部分的最大长度,组成最大长度表
        字符串ABCDABD
        子串          前缀                      后缀                      最大公共元素长度
        A            无                           0
        AB           A                          B                           0
        ABC          A,AB                       C,BC                        0
        ABCD         A,AB,ABC                   D,CD,BCD                    0
        ABCDA        A,AB,ABC,ABCD              A,DA,CDA,BCDA               1
        ABCDAB       A,AB,ABC,ABCD,ABCDA        A,DA,CDA,BCDA,BCDAB         2
        ABCDABD      A,AB,ABC,ABCD,ABCDA,ABCDAB A,DA,CDA,BCDA,BCDAB,BCDABD  0

        最大长度表（next数组的雏形）
        ABCDABD
        0000120

        next数组
        A   B   C   D   A   B   D
        -1  0   0   0   0   1   2

        某个字符失配时,模式串右移的位数=失配字符所在位置-失配字符在next数组中的值（以next数组来说）
                                  =已匹配字符数-失配字符的上个字符在最大长度表中的值（以最大长度表来说）


     */
    public static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;//字符串第一个字符肯定是没有前缀跟后缀的,那么最大公共元素的长度也就为0


        //i指向源字符串
        //j指向子串
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                next[i] = j;
            }
        }
        return next;

    }
}

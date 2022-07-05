package com.zyh.hsp_datastructure.algorithm.search;

import java.util.ArrayList;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,3,1,4,0};
        ArrayList<Integer> res = seq(arr,1);
        System.out.println(res);
    }
    public static ArrayList<Integer> seq(int[] arr,int value){
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                res.add(i);
            }
        }
        return res;
    }

}

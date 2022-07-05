package com.zyh.hsp_datastructure.algorithm.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(mul(5));
    }
    public static int mul(int n){
        if(n==1){
            return 1;
        }else{
            return mul(n-1)*n;
        }

    }
}

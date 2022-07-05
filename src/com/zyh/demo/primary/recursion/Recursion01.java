package com.zyh.demo.primary.recursion;

public class Recursion01 {
    public static void main(String[] args){
        B b = new B();
        int res = b.factorial(5);
        System.out.println(res);
    }
}
class B{
//  阶乘
    public int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }

}

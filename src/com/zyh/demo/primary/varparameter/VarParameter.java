package com.zyh.demo.primary.varparameter;

public class VarParameter {
    public static void main(String[] args){
        P p = new P();
        int[] arr = {1,2,3,4};
        System.out.println(p.sum(1,2,3,4,5));
        System.out.println(p.sum(1.5,2,3));
        System.out.println(p.sum(1.5,arr));


    }
}
class P{
    public P(){}
//  可变长度参数
//  修饰符 返回值 方法名(参数类型...参数名)
//  ...表明这个方法可以接受任意数量的参数
//  1.可变参数的实参可以是数组
//  2.可变参数的本质是数组
//  3.可变参数要放在最后
    public double sum(double N,int...num){
        double res = N;
        for(int i=0;i<num.length;i++){
            res+=num[i];
        }
        return res;
    }
}

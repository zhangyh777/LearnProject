package com.zyh.demo.primary;

public class ReloadMethods {
    public static void main(String[] args){
        Methods method = new Methods();
        method.m(5);
        method.m(5,6);
        method.m("zyh");
        System.out.println(method.max(5,9));
        System.out.println(method.max(0.5,0.1));
        System.out.println(method.max(1.5,2.1,1.2));

    }
}
class Methods{
    public Methods(){}
    public void m(int n){
        System.out.println(n*n);
    }
    public void m(int n,int m){
        System.out.println(n*m);
    }
    public void m(String str){
        System.out.println(str);
    }
    public int max(int n,int m){
        return (n>m?n:m);
    }
    public double max(double n,double m){
        return(n>m?n:m);
    }
    public double max(double n,double m,double l){
        double Max = n>m?n:m;
        return Max>l?Max:l;
    }
}

package com.zyh.demo.primary.test;

public class Test05 {
    public static void main(String[] args){
        Circle y = new Circle(0.5);
        var C = y.showC();
        var S = y.showS();
        System.out.println(C);
        System.out.println(S);

    }
}
class Circle{
    double r;
    public Circle(double r){
        this.r = r;
    }
    public double showC(){
        return 2*Math.PI*this.r;
    }
    public double showS(){
        return Math.PI*Math.pow(this.r,2);
    }
}

package com.zyh.demo.primary.test;

public class Test13 {
    public static void main(String[] args){
        CirCle1 C1 = new CirCle1(5.6);
        System.out.println(C1.findArea());
        PassObject p1 = new PassObject();
        p1.printAreas(C1,4);



    }
}
class CirCle1{
    double radius;
    public CirCle1(double radius){
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI*Math.pow(radius,2);
    }
//  修改半径
    public void setRadius(double newR){
//      为属性赋新值
        this.radius = newR;
    }
}
class PassObject{
    public void printAreas(CirCle1 c,int times){
        System.out.print("Radius"+"\t\t\t"+"Area");
        System.out.println();
        for(int i=1;i<=times;i++){
            c.setRadius(i);
            System.out.print(c.radius+"\t\t\t"+c.findArea());
            System.out.println();
        }
    }
}

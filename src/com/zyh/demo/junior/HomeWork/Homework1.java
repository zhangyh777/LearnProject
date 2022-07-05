package com.zyh.demo.junior.HomeWork;

public class Homework1 {
    public static void main(String[] args) {
        CCar c = new CCar();
        CCar c1 = new CCar(100);
        System.out.println(c);
        System.out.println(c1);
    }
}
class CCar{
    double price = 10;
    static String color = "white";

    @Override
    public String toString() {
        return price+"\t"+color;
    }

    public CCar() {
        this.price = 9;
        this.color = "red";
    }
    public CCar(double price){
        this.price = price;
    }
}

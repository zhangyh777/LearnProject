package com.zyh.demo.primary.test;

public class Test06 {
    public static void main(String[] args){
        Cale cal01 = new Cale(2.4,3.1);
        Cale cal02 = new Cale(2.4,0);
        System.out.println(cal01.plus());
        System.out.println(cal01.minus());
        System.out.println(cal01.mult());
        System.out.println(cal01.div());

        System.out.println(cal02.div());

    }
}
class Cale{
    double n1;
    double n2;
    public Cale(double n1,double n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public double plus(){
        System.out.print(this.n1+"+"+this.n2+"=");
        return n1+n2;
    }
    public double minus(){
        System.out.print(this.n1+"-"+this.n2+"=");


        return n1-n2;
    }
    public double mult(){
        System.out.print(this.n1+"*"+this.n2+"=");


        return n1*n2;
    }
    public Double div(){
        if(n2==0){
            System.out.println("除数n2不能为0");
            return null;
        }else{
            System.out.print(this.n1+"/"+this.n2+"=");

            return n1/n2;

        }
    }
}

package com.zyh.demo.junior.HomeWork;

public class HomeWork4 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        },1224,1987);
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                return n1*n2;
            }
        },12,24);
    }
}
interface Computer{
    public abstract double work(double n1,double n2);
}
class CellPhone implements Computer{
    @Override
    public double work(double n1,double n2){
        return n1+n2;
    }
    public void testWork(Computer computer,double n1,double n2){
        double res = computer.work(n1,n2);
        System.out.println(res);
    }

}

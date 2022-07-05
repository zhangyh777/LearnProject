package com.zyh.demo.junior.HomeWork;

public class Homework2{
    public static void main(String[] args) {

    }
}
class Frock{
    private static int currentNum = 100000;
    private int serialNum;

    public int getSerialNum() {
        return serialNum;
    }

    public Frock() {
        serialNum = getNextNum();
    }

    public static int getNextNum(){
        currentNum+=100;
        return currentNum;
    }

}
class TestFrock{
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNum());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNum());

        Frock frock3 = new Frock();
        System.out.println(frock3.getSerialNum());
    }
}
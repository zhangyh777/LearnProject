package com.zyh.demo.primary.ploy.homework;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println("Worker类的work()方法.");
    }
    @Override
    public double getAnnual(){
        return super.getAnnual();
    }
}

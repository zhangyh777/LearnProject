package com.zyh.demo.junior.AbstractClass;

public class Test {
    public static void main(String[] args) {
        Employee commonEmployee = new CommonEmployee("zyh",1987,2000);
        Manager manager = new Manager("satomi",1224,5000);
        manager.setBonus(2000);
        System.out.println(manager.getBonus());
        System.out.println(manager.getSalary());
        commonEmployee.work();
        manager.work();
    }

}
abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    abstract void work();

}
class CommonEmployee extends Employee{

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work(){
        System.out.println("员工"+getName()+"工作中");
    }
}
class Manager extends CommonEmployee{
    private double bonus;
    public Manager(String name,int id,double salary){
        super(name, id, salary);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
    @Override
    public double getSalary(){
        return super.getSalary()+getBonus();
    }

    @Override
    public void work(){
        System.out.println("经理"+getName()+"工作中");

    }
}

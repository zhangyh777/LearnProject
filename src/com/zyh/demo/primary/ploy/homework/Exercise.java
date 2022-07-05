package com.zyh.demo.primary.ploy.homework;

public class Exercise {
    public static void main(String[] args) {
        Exercise exercise = new Exercise();

        Employee employee = new Employee("zyh",30000);

        Manager manager = new Manager("satomi",50000,5000);

        Worker worker = new Worker("hhh",1224);

        System.out.println(employee.getAnnual());
        System.out.println(manager.getAnnual());

        exercise.showEmpAnnual(worker);
        exercise.testWork(manager);

    }
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker) e).work();
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }else{
            System.out.println("类型有误!");
        }
    }


}



package com.zyh.demo.primary.encap;

public class Encap01 {
    public Encap01() {}


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("zyhzyhzyh");//name设置不符合要求，设为null
        p1.setAge(240);//age设置不符合要求，设置为默认值30
        p1.setSalary(30000);//salary=30000
        p1.info();
        System.out.println("======");
//      没有和方法结合的构造器
//      age，salary由构造器来初始化
        Person p2 = new Person("zhangyunhao",333);//age=333
        p2.info();
        System.out.println("======");


//      和方法结合的构造器
//      name，age，salary分别由setName(),setAge(),setSalary()来完成，不用构造器
        Person p3 = new Person("zyhzyh",1224,20000);
        p3.info();




    }
}
class Person{
    public String name;
    private int age;
    private int salary;

    public Person() {
    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;

    }

    //  将构造器和方法setXXXX方法结合
    //  属性设置会受到方法的限制
    public Person(String name, int age, int salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>1&&name.length()<7){
            this.name = name;
        }else{
            System.out.println("名字长度不对，设置为默认值null！");
            this.name = null;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0&&age<=120){
            this.age = age;
        }else{
            System.out.println("设置的年龄不对，设置为默认值30！");
            this.age = 30;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void info(){
        System.out.println("员工信息：");
        System.out.print("name:"+name+"\t"+"age:"+age+"\t"+"salary:"+salary);
        System.out.println();
    }
}

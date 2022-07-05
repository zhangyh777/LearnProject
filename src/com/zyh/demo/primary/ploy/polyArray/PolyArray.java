package com.zyh.demo.primary.ploy.polyArray;

public class PolyArray {
    public static void main(String[] args) {
        Person[] arr = new Person[5];
        Person p1 = new Person("p1",0);
        Students s1 = new Students("s1",1,100.0);
        Students s2 = new Students("s2",2,99.0);
        Teacher t1 = new Teacher("t1",11,1000);
        Teacher t2 = new Teacher("t2",22,2000);
        arr[0] = p1;
        arr[1] = s1;
        arr[2] = s2;
        arr[3] = t1;
        arr[4] = t2;
//      arr[4].teach();不行,arr[4]为Person父类对象，不能访问Teacher子类特有的方法
//      t2.teach();行
        for(int i =0;i<arr.length;i++){
//          方法动态绑定机制，对不同子类的对象调用各自重写的父类的方法
            System.out.println(arr[i].say());
//          向下转型，调用子类对象特有的方法
            if(arr[i] instanceof Students){
                ((Students) arr[i]).study();
            }
            if(arr[i] instanceof Teacher){
                ((Teacher) arr[i]).teach();
            }
        }


    }




}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String say(){
        return "name:"+name+"\tage:"+age+"\t";
    }

}
class Students extends Person{
    private double score;

    public Students(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

//  重写父类方法
    public String say(){
        return super.say()+"score:"+score;
    }
//  Students类独有方法
    public void study(){
        System.out.println("学生 "+getName()+"正在学习.");
    }
}
class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

//  重写父类方法
    public String say(){
        return super.say()+"salary:"+salary;
    }
//  Teacher类独有方法
    public void teach(){
        System.out.println("老师 "+getName()+"正在授课.");
    }
}
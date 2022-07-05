package com.zyh.demo.junior.comparable;


public class Students implements Comparable<Students>{

    private String name;
    private int age;
    private double score;

    public Students(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /*
        内部比较器,类要实现Comparable接口,重写compareTo方法
     */
    @Override
    public int compareTo(Students o) {
        //实质还是调用String的compareTo方法
        return this.getName().compareTo(o.getName());
    }
}

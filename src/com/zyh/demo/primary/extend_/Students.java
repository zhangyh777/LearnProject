package com.zyh.demo.primary.extend_;

public class Students {
    public String name;
    public int age;
    private double score;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public void info(){
        System.out.print("name:"+name+"age:"+age+"score:"+score);
    }
}


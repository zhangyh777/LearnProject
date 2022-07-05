package com.zyh.hsp_datastructure.algorithm.sort;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setUsername("zhangsan");
        stu1.setAge(17);

        Student stu2 = new Student();
        stu2.setUsername("lisi");
        stu2.setAge(19);

        Comparable max = getMax(stu1, stu2);
        System.out.println(max);
    }
    //测试方法，获取两个元素中的较大值
    public static Comparable getMax(Comparable c1,Comparable c2){
        int cmp = c1.compareTo(c2);
        if (cmp>=0){
            return c1;
        }else{
            return c2;
        }
    }
}

//学生类
class Student implements Comparable<Student>{
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
    //定义比较规则
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }
}
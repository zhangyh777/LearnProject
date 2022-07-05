package com.zyh.demo.primary.override;

public class Exercise {
    public static void main(String[] args) {
        Person person = new Person("zyh",24);
        Student student = new Student("satomi",33,1224,66);
        String info1 = person.say();
        String info2 = student.say();
        System.out.println(info1);
        System.out.println(info2);
    }
}

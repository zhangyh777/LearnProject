package com.zyh.demo.primary.extend_;

public class TestExtends {
    public static void main(String[] args) {
        Students students = new Students();
        students.setName("zyh");
        students.setAge(24);
        students.setScore(66);

        Pupil pupil = new Pupil();
        pupil.setName("xiaoming");
        pupil.setAge(10);
        pupil.setScore(96);
        pupil.testing();

    }
}

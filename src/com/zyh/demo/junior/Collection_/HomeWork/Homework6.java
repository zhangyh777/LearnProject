package com.zyh.demo.junior.Collection_.HomeWork;

import java.util.HashSet;
import java.util.Objects;

public class Homework6 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        P p1 = new P(1001,"AA");
        P p2 = new P(1002,"BB");
        hashSet.add(p1);
        hashSet.add(p2);

        p1.name = "cc";
        hashSet.remove(p1);
        System.out.println(hashSet);

        hashSet.add(new P(1001,"cc"));
        System.out.println(hashSet);
        hashSet.add(new P(1001,"AA"));
        System.out.println(hashSet);


    }
}
class P{
    public int id;
    public String name;

    public P(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        P p = (P) o;
        return id == p.id && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "P{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

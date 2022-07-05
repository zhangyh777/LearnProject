package com.zyh.demo.junior.Collection_.Set_;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("BMW",20000));
        linkedHashSet.add(new Car("MINI",10000));
        linkedHashSet.add(new Car("BMW",20000));
        Iterator iterator = linkedHashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }


    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return car.price == price && car.name == name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

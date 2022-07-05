package com.zyh.demo.junior.IO.Homework;

import java.io.*;
import java.util.Properties;

/**
 * Author:zyh
 * Version:1.0
 */
public class homework3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        String path = "src\\com\\zyh\\demo\\junior\\IO\\Homework\\dog.properties";
        properties.load(new FileReader(path));
        properties.list(System.out);
        //Object转String
        String name = properties.get("name")+"";
        String color = properties.get("color")+"";
        //Object转int
        int age = Integer.parseInt(properties.get("age")+"");


        //用properties文件信息创建对象
        Dog dog = new Dog(name,age,color);
        System.out.println(dog);
        //序列化
        String serializablefile = "src\\com\\zyh\\demo\\junior\\IO\\Homework\\dog.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializablefile));
        oos.writeObject(dog);
        oos.close();
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializablefile));
        System.out.println("反序列化->"+ois.readObject());
    }
}
class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

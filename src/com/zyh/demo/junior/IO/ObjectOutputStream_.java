package com.zyh.demo.junior.IO;


import java.io.*;

/**
 *
 *  序列化：保存数据时，不是单一的保存数据的值，而是保存 值+数据类型
 *  反序列化：恢复数据时，恢复数据的 值+数据类型
 *  要让某个类对象支持序列化机制，则该类必须实现Serializable接口或者Externalizable接口
 *  并且该类中的属性也要实现Serializable接口
 *  推荐实现Serializable接口,没有定义任何方法，是一个空接口（标记接口）
 *  Externalizable接口的话有两个方法要重写
 *
 *
 *
 *  ObjectOutputStream可以实现序列化，
 *  ObjectInputStream可以实现反序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //文件并不是以我们指定的格式保存，而是以他自己的格式保存
        String filePath = "\\src\\com\\zyh\\demo\\junior\\IO\\TestFile\\ObjectOutputStream.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        //反序列化目标文件
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        //写入内容，序列化
        oos.writeInt(1224);//Integer(实现了Serializable接口)
        oos.writeBoolean(false);//Boolean(实现了Serializable接口)
        oos.writeUTF("ZYH");//写入字符串
        oos.writeObject(new Worker("satomi",10000,"worker"));//写入实现了Serializable接口的对象

        //反序列化,读取顺序要和写入顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());
        //obj的编译类型是Object,运行类型是Worker
        Object obj = ois.readObject();
        System.out.println(obj);//Worker类的toString
        //向下转型,调用具体类的具体方法
        //且该类必须得放在可以引用的位置
        Worker worker = (Worker) obj;
        System.out.println("name= "+worker.getName());


        oos.close();
        System.out.println("序列化成功");

        ois.close();
        System.out.println("反序列化成功");

    }
}
class Worker implements Serializable{
    private String name;
    private int sal;
    //static 和transient 修饰的属性不会被序列化
    //如果序列化和反序列化在一个线程里，反序列化还是能访问到static和transient修饰的属性
    private static String job;
    //属性也要实现Serializable接口
    private A a = new A();

    public Worker(String name, int sal, String job) {
        this.name = name;
        this.sal = sal;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", job=" + job +
                ", a=" + a +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public static String getJob() {
        return job;
    }

    public static void setJob(String job) {
        Worker.job = job;
    }
}
class A implements Serializable{
    private String kind = "A";


}

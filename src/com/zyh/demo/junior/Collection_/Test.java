package com.zyh.demo.junior.Collection_;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new B("三国演义","罗贯中",29.6));
        list.add(new B("西游记","吴承恩",19.6));
        list.add(new B("红楼梦","曹雪芹",39.6));
        bubble(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        ArrayList list1 = new ArrayList(8);
        list1.size();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        list1.add("a");

    }
    public static void bubble(ArrayList arrlist){
//  public static void bubble(ArrayList<Book> list){}
//  指定集合元素类型为Book类

        for(int i=0;i<arrlist.size()-1;i++){

            for(int j=0;j< arrlist.size()-i-1;j++){
//              任何对象加入集合类后，自动转变为Object类型，
//              所以在取出的时候，需要进行强制类型转换。
//              如果在定义集合类型时就指定元素类型，那么就不用再转型
//              向下转型
                B bj = (B) arrlist.get(j);
                B BJ = (B) arrlist.get(j+1);
                if(bj.getPrice()>BJ.getPrice()){
                    var temp = bj;
                    arrlist.set(j,BJ);
                    arrlist.set(j+1,temp);
                }
            }
        }
    }
}
class B{
    private String name;
    private String author;
    private double price;

    public B(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

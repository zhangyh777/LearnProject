package com.zyh.demo.junior.CommonlyUsedClass.ArraysClass;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.price从大到小
 * 2.price从小到大
 * 3.书名长度排序
 */
public class TestArrays {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("红楼梦a",100);
        books[1] = new Book("金瓶梅ccc",90);
        books[2] = new Book("西游记bb",80);
        books[3] = new Book("三国演义e",110);
        books[4] = new Book("水浒传dddd",70);
//      按价格排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1,Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
//              price类型为double,返回值要求是int
                double res = b1.getPrice()-b2.getPrice();
//              映射一下
                if(res>0){
                    return 1;
                }else if(res<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));
//      按书名长度排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1,Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return  b1.getName().length() - b2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));

    }

}
class Book{
    private String name;
    private double price;
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + name + ", "+ price + "}";
    }

}

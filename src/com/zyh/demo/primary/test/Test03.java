package com.zyh.demo.primary.test;

public class Test03 {
    public static void main(String[] args){
        Book b = new Book("AAA",170);
        b.info();
        b.updatePrice();
        b.info();
    }
}
class Book{
    String name;
    int price;
    public Book(String Name,int price){
        name = Name;
        this.price = price;
    }
    public void updatePrice(){
        if(price>150){
            price = 150;
        }else if(price>100){
            price = 100;
        }
    }
    public void info(){
        System.out.println("书籍信息："+"\t"+"name:"+this.name+"\t"+"price:"+this.price);
    }

}



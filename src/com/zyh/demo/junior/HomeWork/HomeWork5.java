package com.zyh.demo.junior.HomeWork;

public class HomeWork5 {
    public static void main(String[] args) {
        A a = new A();
        a.f();

    }
}
class A{
    private String name = "zyh";
    public void f(){
        class B{
            private final String name = "satomi";
            public void show(){
                System.out.println("B.name= "+name);
                System.out.println("A.name= "+A.this.name);
            }
        }
        B b = new B();
        b.show();
    }

}

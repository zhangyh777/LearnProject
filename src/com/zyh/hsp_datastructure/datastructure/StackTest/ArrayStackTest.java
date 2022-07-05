package com.zyh.hsp_datastructure.datastructure.StackTest;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while(loop){
            System.out.println("a(往栈中添加数据)");
            System.out.println("p(从栈里取出数据)");
            System.out.println("s(显示栈里的数据)");
            System.out.println("e(退出系统)");
            System.out.println("输入命令：");

            key = scanner.next().charAt(0);
            switch(key){
                case 'a':
                    System.out.println("输入要添加的数据：");
                    int num = scanner.nextInt();
                    try{
                        stack.push(num);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try{
                        int res = stack.pop();
                        System.out.println("出栈数据为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    try{
                        stack.show();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }




    }
}
class ArrayStack{
    public int size;
    public int top = -1;
    public int value;
    public int[] stack;//只是声明数组,没有分配空间

    public ArrayStack(int size) {
        this.size = size;
        this.stack = new int[this.size];//给数组分配空间
    }
    public boolean isFull(){
        return top==size-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int num){
        if(isFull()){
            throw new RuntimeException("栈已满，无法添加");
        }
        top++;
        stack[top] = num;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空，无法取出");
        }
        value = stack[top];
        top--;
        return value;
    }
    //遍历栈（后进先出，从栈顶开始显示）
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("栈是空的，无法遍历");
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }

}

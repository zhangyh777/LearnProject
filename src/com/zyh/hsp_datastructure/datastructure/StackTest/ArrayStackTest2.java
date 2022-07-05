package com.zyh.hsp_datastructure.datastructure.StackTest;
import java.util.Scanner;


/**
 * 栈来模拟算术运算
 * +-/*运算符用数字大小来代替，数字越大优先级越高
 * 使用栈完成表达式的计算思路
 * 1.通过一个index值（索引）,来遍历我们的表达式
 * 2.如果我们发现是一个数字,就直接入数栈
 * 3.如果发现扫描到是一个运算符号,就分如下情况
 *  3.1如果发现当前的符号栈为空,就直接入栈
 *  3.2如果符号栈有操作符，就进行比较,
 *     如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数,再从符号栈中pop出一个符号，进行运算，
 *     将得到结果，入数柱，然后将当前的操作符入符号栈，
 *     如果当前的操作符的优先级大于栈中的操作符,就直接入符号栈.
 * 4.当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号，并运行.
 * 5.最后在数栈只有一个数字,就是表达式的结果
 */
public class ArrayStackTest2 {
    public static void main(String[] args) {
        String expression = "1+2*5+4";
        //数栈
        ArrayStack3 numStack = new ArrayStack3(10);
        //运算符栈
        ArrayStack3 operateStack = new ArrayStack3(10);

        int num1 = 0;
        int num2 = 0;
        int operation = 0;//运算符
        int res = 0;//存放运算结果
        int index = 0;//用来索引算术表达式
        char ch = ' ';//存储算术表达式索引的字符
        //索引算术表达式
        while(true){
            ch = expression.substring(index,index+1).charAt(0);//一次只索引一个字符，多位数无法正确索引
            //如果索引到的字符是运算符
            if(operateStack.isOperate(ch)){
                if(operateStack.isEmpty()){//如果此时运算符栈为空，将索引到的运算符直接入栈
                    operateStack.push(ch);
                }else{//如果此时运算符栈不为空，进行优先级判断
                    //如果此时运算符优先级小于等于栈顶的运算符优先级，
                    //从数栈里出栈两个数，运算符栈里出栈一个运算符进行算术运算
                    if(operateStack.priority(ch)<=operateStack.priority(operateStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operation = operateStack.pop();
                        res = operateStack.cal(num1,num2,operation);//算术运算
                        numStack.push(res);//将运算结果入栈
                        operateStack.push(ch);//将当前运算符入栈
                    }else{//如果当前运算符大于栈顶的运算符，运算符直接入栈
                        operateStack.push(ch);
                    }
                }
            }else{//如果索引到的不是运算符而是数，直接入栈
                numStack.push(Integer.parseInt(ch+""));
            }
            index++;//往下继续索引
            if(index>=expression.length()){//算术表达式索引完毕
                break;
            }
        }
        //算术表达式索引完毕之后，开始运算
        while(true){
            if(operateStack.isEmpty()){//运算符栈为空时，算术运算就结束了，此时数栈里面还剩一个元素（最后的运算结果）
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operation = operateStack.pop();
            res = operateStack.cal(num1,num2,operation);
            numStack.push(res);
        }
        int finalRes = numStack.pop();//数栈里最后一个元素，就是结果
        System.out.println(finalRes);
    }
}

class ArrayStack2 {
    public int size;
    public int top = -1;
    public int[] stack;//只是声明数组,没有分配空间

    public ArrayStack2(int size) {
        this.size = size;
        this.stack = new int[this.size];//给数组分配空间
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈已满，无法添加");
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空，无法取出");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //获取栈顶元素，但不出栈
    public int peek() {
        return stack[top];
    }

    //遍历栈（后进先出，从栈顶开始显示）
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈是空的，无法遍历");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //运算符判断
    public boolean isOperate(int c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    //运算符优先级,用数字表示
    public int priority(int c) {
        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 算术运算函数
     *
     * @param n1      先出栈的元素
     * @param n2      n1后边又出栈的元素
     * @param operate 运算符
     * @return
     */
    public int cal(int n1, int n2, int operate) {
        int res = 0;
        switch (operate) {
            case '+':
                res = n2 + n1;
                break;
            case '-':
                //入栈：左边的数先入栈，在下边，右边的数后入栈，在上边，
                //出栈：上边的数（表达式右边的数）先出，下边的数（表达式左边的数）后出
                //减法的话，就是后出的数-先出的数
                res = n2 - n1;
                break;
            case '*':
                res = n2 * n1;
                break;
            case '/':
                res = n2 / n1;
                break;
            default:
                break;
        }
        return res;
    }


}



package com.zyh.hsp_datastructure.datastructure.StackTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 可用于带括号的多位数（包含小数）运算
 */
public class Demo4 {
    public static void main(String[] args) {
        String expression = "2.5*(15-3)-(7-2)";
        List<String> infixArrayList = toArrayList(expression);//字符串转为字符串数组
        Stack<String> reversePolandStack = toPolandExpression(infixArrayList);


        ArrayList<String> reversePolandList = new ArrayList<>();//后缀表达式的逆序数组
        while (reversePolandStack.size()>0){
            reversePolandList.add(reversePolandStack.pop());
        }
        ArrayList<String> polandList = new ArrayList<>();//真正的后缀表达式数组
        for (int i = reversePolandList.size()-1; i >= 0; i--) {
            polandList.add(reversePolandList.get(i));
        }
        double res = calByPoland(polandList);
        System.out.println(res);


    }
    public static double calByPoland(ArrayList<String> list){
        Stack<String> stack = new Stack<>();
        double n1;
        double n2;
        double res;
        for (String read:list
             ) {
            if(read.matches("\\d+")||read.matches("\\d+\\.\\d+")){
                stack.push(read);
            }else{
                n1 = Double.parseDouble(stack.pop());
                n2 = Double.parseDouble(stack.pop());
                res = cal(n1,n2,read);
                stack.push(""+res);
            }
        }
        return Double.parseDouble(stack.peek());
    }
    //中缀表达式转后缀表达式
    public static Stack<String> toPolandExpression(List<String> infixArrayList){
        //1.一个栈存数字，一个栈放符号
        Stack<String> numStack = new Stack();
        Stack<String> operateStack = new Stack();
        //2.遍历数组
        for (String read: infixArrayList
        ) {
            if(read.matches("\\d+")||read.matches("\\d+\\.\\d+")){//匹配到整数(包含多位数)或则小数,直接入栈
                numStack.push(read);
            }else{//如果是运算符  +-/*()
                if(read.equals("(")){//左括号直接入栈
                    operateStack.push(read);
                }else if(read.equals(")")){//右括号的话，从符号栈弹出一个符号到数栈，直到遇见左括号，最后再将这个左括号抛出
                    while(!operateStack.peek().equals("(")){
                        numStack.push(operateStack.pop());
                    }
                    operateStack.pop();
                }else{
                    while(true){
                        if(operateStack.isEmpty()||operateStack.peek().equals("(")){
                            operateStack.push(read);
                            break;
                        }else if(priority(read)>priority(operateStack.peek())){
                            operateStack.push(read);
                            break;
                        }else{
                            numStack.push(operateStack.pop());
                        }
                    }

                }
            }
        }
        while(operateStack.size()>0){//将符号栈里的元素压入数栈
            numStack.push(operateStack.pop());
        }
        //数栈再逆序输出就是后缀表达式
        return numStack;

    }

    //字符串转数组
    public static List<String> toArrayList(String expression) {
        List<String> resArrayList = new ArrayList<>();

        int index = 0;
        String read = "";
        String temp = "";
        while (index < expression.length()) {
            read = expression.substring(index, index + 1);
            if (isOperate(read)) {//如果是符号，直接存到数组
                resArrayList.add(read);
                index++;
            } else {
                do {
                    read = expression.substring(index, index + 1);
                    temp += read;//拼接
                    index++;
                } while (index < expression.length()//字符串没有遍历完 并且 当前字符为数字或者小数点的话就继续往下遍历
                        && ((expression.charAt(index) <= '9' && expression.charAt(index) >= '0') || '.' == expression.charAt(index)));
                resArrayList.add(temp);
                temp = "";

            }
        }
        return resArrayList;

    }

    public static boolean isOperate(String operation) {
        return (operation.equals("+")
                || operation.equals("-")
                || operation.equals("*")
                || operation.equals("/")
                || operation.equals("(")
                || operation.equals(")"));
    }


    public static int priority(String operation){
        int res = -1;
        switch (operation){
            case "+":
            case "-":
                res = 0;
                break;
            case "*":
            case "/":
                res = 1;
                break;
            default:
                break;
        }
        return res;
    }
    public static double cal(double n1,double n2,String operation){
        double res = 0;
        switch (operation){
            case "+":
                res = n2+n1;
                break;
            case "-":
                res = n2-n1;
                break;
            case "*":
                res = n2*n1;
                break;
            case "/":
                res = n2/n1;
                break;
        }
        return res;
    }
}

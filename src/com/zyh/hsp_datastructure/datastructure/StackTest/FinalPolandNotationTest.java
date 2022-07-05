package com.zyh.hsp_datastructure.datastructure.StackTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * 1)初始化两个栈:运算符栈s1和储存中间结果的栈s2:
 * 2)从左至右扫描中缀表达式;
 * 3)遇到操作数时，将其压入s2:
 * 4)遇到运算符时，比较其与s1栈顶运算符的优先级:
 *  4.1.如果s1为空，或s1栈顶运算符为左括号“(”，则直接将此运算符入栈s1;
 *  4.2.如果优先级比s1栈顶运算符的高，也将运算符压入s1;
 *  4.3.否则(运算符优先级小于等于栈顶的优先级)，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较;
 * 5)遇到括号时:
 *  5.1.如果是左括号“(”，则直接压入s1
 *  5.2.如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 6)重复步骤2至5，直到表达式的最右边
 * 7)将s1中剩余的运算符依次弹出并压入 s2
 * 8)依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class FinalPolandNotationTest {
    public static void main(String[] args) {
        String str = "1.5+((2+3)*4)-5";
        ArrayList<String> InfixList = toInfixArrayList(str);//中缀表达式存放到ArrayList中
        System.out.println("中缀表达式为：[");
        for (String e : InfixList
        ) {
            System.out.println(e);
        }
        System.out.println("]");

        List<String> PolandList = toPolandExpression(InfixList);
        System.out.print("后缀表达式为：[");
        for (String s : PolandList
        ) {
            System.out.print(s);
        }
        System.out.println("]");

        double n = calPoland(PolandList);
        System.out.println("运算结果为：" + n);

    }


    //将中缀表达式的字符存放到数组中,暂时不能放小数
//    public static ArrayList<String> toInfixExpressionList(String str) {
//        ArrayList<String> InfixList = new ArrayList<>();
//        int index = 0;
//        char ch;//存放遍历到的字符
//        String temp;
//        do {
//            if ((ch = str.charAt(index)) < '0' || (ch = str.charAt(index)) > '9') {//如果字符不是数字，直接存放到数组
//                InfixList.add("" + ch);
//                index++;
//            } else {//如果是数字的话，还需要考虑多位数
//                temp = "";
//                while (index < str.length() && (ch = str.charAt(index)) >= '0' && (ch = str.charAt(index)) <= '9') {
//                    temp += ch;
//                    index++;
//                }
//                InfixList.add(temp);
//            }
//        } while (index < str.length());
//        return InfixList;
//    }

    //传入中缀表达式字符串，返回中缀表达式数组，小数同样适用
    public static ArrayList<String> toInfixArrayList(String infixStr) {
        ArrayList<String> infixArray = new ArrayList<>();
        int index = 0;
        String ch = "";
        String temp = "";
        do {
            ch = infixStr.substring(index, index + 1);
            if (isOperate(ch)) {
                infixArray.add(ch);
                index++;
            } else {
                do {
                    ch = infixStr.substring(index, index + 1);
                    temp += ch;
                    index++;
                } while ((index < infixStr.length())
                        && ((infixStr.charAt(index) <= '9' && infixStr.charAt(index) >= '0') || '.' == infixStr.charAt(index)));
                infixArray.add(temp);
                temp = "";
            }
        }while(index<infixStr.length());
        return infixArray;
    }

    //传入中缀表达式的数组，生成后缀表达式的数组
    public static List<String> toPolandExpression(ArrayList<String> InfixList) {
        //1.创建数栈（存放数）和符号栈（存放运算符和括号）
        //因为数栈一直都只有入栈操作而没有出栈操作，最后还要逆序输出，所以用List更好
        //Stack<String> numList = new Stack();
        List<String> numList = new ArrayList<>();//将数栈换成ArrayList
        Stack<String> operateStack = new Stack();
        //2.遍历中缀表达式
        for (String s : InfixList
        ) {
            if (s.matches("\\d+")||s.matches("\\d+\\.\\d+")) {//如果是数字(包括小数)的话直接入栈
                numList.add(s);
            } else if (s.equals("(")) {//如果是左括号，直接入栈
                operateStack.push(s);
            } else if (s.equals(")")) {//如果是右括号
                while (!(operateStack.peek().equals("("))) {//符号栈顶元素不为左括号
                    numList.add(operateStack.pop());//将符号栈顶元素弹出并入到数栈
                }//while循环走完，栈顶元素就为左括号（和当前右括号配对的左括号）
                operateStack.pop();//将此时栈顶的左括号（和当前遍历到的的右括号配对的）删除，当前遍历到的右括号没有入栈操作，相当于把这对括号同时丢弃了
            } else {//如果是运算符的话
                //当前运算符优先级小于等于operateStack栈顶的优先级，将operateStack栈顶的运算符弹出压入numStack
                while (operateStack.size() != 0 && priority(s) <= priority(operateStack.peek())) {
                    numList.add(operateStack.pop());
                }
                operateStack.push(s);
            }
        }
        //中缀表达式遍历完比
        //将运算符栈里的元素依次压入到数栈
        while (operateStack.size() != 0) {
            numList.add(operateStack.pop());
        }
        return numList;

    }

    //计算后缀表达式的结果
    public static double calPoland(List<String> polandList) {
        Stack<String> stack = new Stack<>();
        double num1 = 0;
        double num2 = 0;
        double res = 0;
        for (String s : polandList
        ) {
            if (s.matches("\\d+")||s.matches("\\d+\\.\\d+")) {//如果遍历到多位数（包括小数）
                stack.push(s);
            } else {
                num1 = Double.parseDouble(stack.pop());
                num2 = Double.parseDouble(stack.pop());
                switch (s) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        break;
                }
                stack.push("" + res);
            }
        }
        return Double.parseDouble(stack.pop());
    }

    public static boolean isOperate(String ch) {
        return (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("(") || ch.equals(")"));
    }

    public static boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    //运算符优先级判断
    public static int priority(String operation) {
        int level = -1;
        switch (operation) {
            case "*":
            case "/":
                level = 1;
                break;
            case "+":
            case "-":
                level = 0;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return level;

    }
}


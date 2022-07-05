package com.zyh.hsp_datastructure.datastructure.StackTest;

public class ArrayStackCompute {
    public static void main(String[] args) {
        String expression = "15.5+16*3-5.5";
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

        String str = "";//拼接多位数索引出的多个单字符

        //索引算术表达式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);//一次只索引一个字符，多位数无法正确索引
            //如果索引到的字符是运算符
            if (operateStack.isOperate(ch)) {
                if (operateStack.isEmpty()) {//如果此时运算符栈为空，将索引到的运算符直接入栈
                    operateStack.push(ch);
                } else {//如果此时运算符栈不为空，进行优先级判断
                    //如果此时运算符优先级小于等于栈顶的运算符优先级，
                    //从数栈里出栈两个数，运算符栈里出栈一个运算符进行算术运算
                    if (operateStack.priority(ch) <= operateStack.priority(operateStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operation = operateStack.pop();
                        res = numStack.cal(num1, num2, operation);//算术运算
                        numStack.push(res);//将运算结果入栈
                        operateStack.push(ch);//将当前运算符入栈
                    } else {//如果当前运算符大于栈顶的运算符，运算符直接入栈
                        operateStack.push(ch);
                    }
                }
            } else if (numStack.isNumber(ch)) {//如果索引到的不是运算符而是数，直接入栈（多位数索引问题bug出处）
                //numStack.push(Integer.parseInt(ch + ""));
                //不能索引到数字之后就立即入栈，而应该继续查看它之后的一个字符
                //如果数字之后的字符是运算符，那么这个数字就索引完了
                //如果数字之后的字符还是数字，那这个数就是多位数，要继续索引并和之前的字符拼接
                str += ch;
                if (index == expression.length() - 1) {//如果当前数字是算术表达式最后一个字符，可以直接入栈
                    numStack.push(Integer.parseInt(str));
                } else {//如果当前字符不是表达式最后一个字符
                    //如果该字符之后是运算符，就停止索引，将该数字入栈
                    if (operateStack.isOperate(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(str));
                        str = "";
                    }
                }
            }
            index++;//往下继续索引
            if (index >= expression.length()) {//算术表达式索引完毕
                break;
            }
        }
        //算术表达式索引完毕之后，开始运算
        while (true) {
            if (operateStack.isEmpty()) {//运算符栈为空时，算术运算就结束了，此时数栈里面还剩一个元素（最后的运算结果）
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operation = operateStack.pop();
            res = numStack.cal(num1, num2, operation);
            numStack.push(res);
        }
        int finalRes = numStack.pop();//数栈里最后一个元素，就是结果
        System.out.println(finalRes);
    }
}

class ArrayStack3 {
    public int size;
    public int top = -1;
    public int[] stack;//只是声明数组,没有分配空间

    public ArrayStack3(int size) {
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

    //数字判断
    public boolean isNumber(int c) {
        return (c <= '9' && c >= '0');
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

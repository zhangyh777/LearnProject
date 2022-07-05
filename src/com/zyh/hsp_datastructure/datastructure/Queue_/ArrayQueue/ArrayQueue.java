package com.zyh.hsp_datastructure.datastructure.Queue_.ArrayQueue;

/**
 * 单向队列有假溢出现象
 * front：指向队列头部元素的前一个位置，初始值为-1
 * rear：指向队列最后一个元素，初始值为-1
 * 添加元素：rear++
 * 删除元素：front++
 * 队列满：rear==max-1
 * 队列空：rear==front
 * 队列中添加元素只有rear发生变化，删除元素只有front发生变化
 * 因此，一旦加入元素之后，即使再删除元素，rear也不会发生改变，
 * 当添加元素直到队列满，即rear==max-1时，无论删除单个元素还是删除所有元素，虽然在数组中有空间可用，但是不能在队列中插入任何更多的元素

 * 改进：循环队列
 */
public class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    public ArrayQueue() {
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }


    public void enQueue(int num){
        if(isFull()){
            throw new RuntimeException("队列已满，无法入队");
        }
        rear++;
        arr[rear] = num;
    }

    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法出队");
        }
        front++;
        return arr[front];
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException ("队列为空，无法获取头元素");
        }
        return arr[front+1];
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法获取数据");
        }
        System.out.print("队列全部元素为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

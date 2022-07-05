package com.zyh.hsp_datastructure.datastructure.Queue_.CircleArrayQueue;

class CircleArrayQueue {
    private int maxSize;
    private int front;//指向第一个元素的位置
    private int rear;//指向最后一个元素的后一个位置
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法再添加元素");
        }
        //rear本就指向队列现有最后元素的后一个位置，添加元素时直接添加
        arr[rear] = num;
        //添加元素之后，rear后移（rear+1），取模是考虑循环队列的原因，rear可能在front前面，不取模的话rear+1可能越界
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取元素");
        }
        //临时保存front指向的元素
        int val = arr[front];
        //front后移（front+1），取模是考虑循环队列的原因，front+1有可能越界
        front = (front + 1) % maxSize;
        return val;
    }

    //有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
            System.out.println();
        }

    }
}

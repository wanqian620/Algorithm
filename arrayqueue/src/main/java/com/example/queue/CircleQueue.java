package com.example.queue;

/**
 * @Author: wanqian
 * @Date: 2020/8/4 9:13
 */
public class CircleQueue {

    public int front;

    public int rear;

    public int[] arr;

    public int size;

    public CircleQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("循环队列已满!");
            return;
        }
        arr[rear] = value;
        rear = (rear + 1) % size;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("循环队列为空");
        }
        int value = arr[front];
        front = (front + 1) % size;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("循环队列为空");
            return;
        }

        for (int i = front; i < front + length(); i++) {
            String format = String.format("arr[%d]=%d", i % size, arr[i % size]);
            System.out.println(format);
        }
    }

    public int length() {
        return (rear + size - front) % size;
    }
}

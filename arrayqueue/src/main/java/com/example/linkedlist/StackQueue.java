package com.example.linkedlist;

/**
 * @Author: wanqian
 * @Date: 2020/8/5 17:44
 */
public class StackQueue {

    private int front;

    private int rear;

    private LinkedNode[] arr;

    private int size;

    public StackQueue(int size) {
        front = 0;
        rear = 0;
        this.size = size;
        this.arr = new LinkedNode[size + 1];
    }

    public void add(LinkedNode linkedNode) {

    }
}

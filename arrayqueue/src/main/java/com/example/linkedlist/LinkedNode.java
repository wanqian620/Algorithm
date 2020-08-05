package com.example.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wanqian
 * @Date: 2020/8/4 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedNode {

    private int id;

    private String name;

    private LinkedNode next;

    public LinkedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

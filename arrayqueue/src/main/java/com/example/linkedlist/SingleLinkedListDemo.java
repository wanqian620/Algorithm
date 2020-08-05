package com.example.linkedlist;

/**
 * @Author: wanqian
 * @Date: 2020/8/5 14:37
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        LinkedNode jack = new LinkedNode(1, "Jack");
        LinkedNode tom = new LinkedNode(2, "Tom");
        LinkedNode kris = new LinkedNode(3, "Kris");
        LinkedNode matthew = new LinkedNode(4, "Matthew");

        LinkedList linkedList = new LinkedList();
        linkedList.addByOrder(matthew);
        linkedList.addByOrder(kris);
        linkedList.addByOrder(jack);
        linkedList.addByOrder(tom);

        linkedList.list();
//        linkedList.length();

//        linkedList.getFromEnd(2);
//        linkedList.getFromEnd(3);

        linkedList.reverse();
        System.out.println("反转链表");
        linkedList.list();
//        System.out.println("删除3号");
//        linkedList.delete(3);
//
//        System.out.println("修改2号");
//        LinkedNode Kristina = new LinkedNode(2, "Matt");
//        linkedList.update(Kristina);
//        linkedList.list();


    }
}

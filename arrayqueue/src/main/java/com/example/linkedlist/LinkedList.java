package com.example.linkedlist;

/**
 * @Author: wanqian
 * @Date: 2020/8/4 15:12
 */
public class LinkedList {

    private LinkedNode head;

    public LinkedNode getHead() {
        return head;
    }

    public LinkedList() {
        this.head = new LinkedNode(0, null);
    }

    public void addNode(LinkedNode linkedNode) {

        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(linkedNode);
    }

    public void addByOrder(LinkedNode linkedNode) {
        LinkedNode temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() > linkedNode.getId()) {
                break;
            } else if (temp.getNext().getId() == linkedNode.getId()) {
                System.out.println("该id已存在：" + linkedNode.getId());
                return;
            }
            temp = temp.getNext();
        }
        linkedNode.setNext(temp.getNext());
        temp.setNext(linkedNode);
    }

    public void update(LinkedNode linkedNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }

        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getId() == linkedNode.getId()) {
                temp.setName(linkedNode.getName());
                return;
            }
        }
        System.out.printf("未找到编号未[%d]的节点！", linkedNode.getId());
    }

    public void delete(int id) {
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }

        LinkedNode temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
        System.out.printf("未找到编号未[%d]的节点！", id);
    }

    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }

        LinkedNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }

    public int length() {
        int num = 0;
        if (head.getNext() == null) {
            System.out.println("链表为空！");
            return num;
        }

        LinkedNode temp = head;
        while (temp.getNext() != null) {
            num++;
            temp = temp.getNext();
        }
        System.out.println("有效节点：" + num);
        return num;
    }

    public LinkedNode getFromEnd(int index) {
        int length = length();

        if (index < 1 || index > length) {
            System.out.println("无效数字");
            return null;
        }

        LinkedNode temp = head.getNext();
        for (int i = 0; i < length - index; i++) {
            temp = temp.getNext();
        }

        System.out.println(String.format("倒数第[%d]个节点是： %s", index, temp.toString()));
        return temp;
    }

    public LinkedList reverse() {
        LinkedNode tempHead = new LinkedNode();
        if (head.getNext() == null) {
            System.out.println("链表为空！");
        }

        LinkedNode temp = head.getNext();
        while (temp != null) {
//            //指针前移
//            temp = temp.getNext();
            //当前指针所指的下一个节点
            LinkedNode next = temp.getNext();

            temp.setNext(null);
            if (tempHead.getNext() != null) {
                temp.setNext(tempHead.getNext());
            }
            tempHead.setNext(temp);
            temp = next;
        }
        head.setNext(tempHead.getNext());

        return this;
    }

    public LinkedList reversePrint() {
        LinkedNode tempHead = new LinkedNode();
        if (head.getNext() == null) {
            System.out.println("链表为空！");
        }

        LinkedNode temp = head.getNext();
        while (temp != null) {
//            //指针前移
//            temp = temp.getNext();
            //当前指针所指的下一个节点
            LinkedNode next = temp.getNext();

            temp.setNext(null);
            if (tempHead.getNext() != null) {
                temp.setNext(tempHead.getNext());
            }
            tempHead.setNext(temp);
            temp = next;
        }
        head.setNext(tempHead.getNext());

        return this;
    }
}

package com.jzl.math.node;

import org.junit.Test;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:04 2020/8/14
 * @Modified By:
 */
public class TestNode {

    @Test
    public void fanZhuan() {
        Node head = getNode();
        Node curNode = reverseMethod2(head,null);
        printNode(curNode);
    }

    /**
     * 递归实现链表反转
     * @param head
     * @param preNode
     * @return
     */
    Node reverseMethod2(Node head,Node preNode){
        if(head == null){
            // 两种情况 1. head为空  2. 遍历到最后的值为null
            return preNode;
        }
        Node next = head.getNext();
        head.setNext(preNode);
        return reverseMethod2(next,head);
    }

    /**
     * while循环实现反转
     * @param head
     * @return
     */
    private Node reverseMthod1(Node head) {
        // 需求 实现反转
        Node preNode = null;
        Node curNode = head;
        Node nextNode;
        while (curNode.getNext() != null){
           nextNode = curNode.getNext();
           curNode.setNext(preNode);
           preNode = curNode;
           curNode = nextNode;
        }
        curNode.setNext(preNode);
        return curNode;
    }

    /**
     * 获取 1-5的链表
     * @return
     */
    private Node getNode(){
        Node<String> head = new Node<>();
        head.setData("1");

        Node<String> next2 = new Node<>();
        next2.setData("2");

        Node<String> next3 = new Node<>();
        next3.setData("3");

        Node<String> next4 = new Node<>();
        next4.setData("4");

        Node<String> next5 = new Node<>();
        next5.setData("5");

        next4.setNext(next5);
        next3.setNext(next4);
        next2.setNext(next3);
        head.setNext(next2);
        return head;
    }

    /**
     * 递归打印表
     * @param node
     */
    void printNode(Node node){
        System.out.println(node.data);
        if(node.getNext() != null){
            printNode(node.getNext());
        }
    }

    /**
     * 遍历链表
     * @param head
     */
    private void foreach(Node<String> head) {
        System.out.println(head.getData());
        while (head.getNext() != null) {
            Node<String> next = head.getNext();
            System.out.println(next.getData());
            head = next;
        }
    }
}

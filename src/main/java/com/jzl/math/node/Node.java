package com.jzl.math.node;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:02 2020/8/14
 * @Modified By:
 */
public class Node<T> {
    T data;
    private Node<T> next;

    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

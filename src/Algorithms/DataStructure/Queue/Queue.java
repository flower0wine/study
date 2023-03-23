package Algorithms.DataStructure.Queue;

import java.util.Objects;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 23 16:04
 *
 * 队列(底层：链表)
 */
public class Queue<T> {
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private int size;

    private static class QueueNode<T> {
        private QueueNode<T> next;
        private T data;

        public QueueNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Queue() {
    }

    public Queue<T> add(T data) {
        if(head == null) {
            head = tail = new QueueNode<>(data);
        } else {
            tail.next = new QueueNode<>(data);
            tail = tail.next;
        }
        size++;
        return this;
    }

    public T remove() {
        if(head == null) return null;
        QueueNode<T> q = head;
        if(head == tail) tail = null;
        head = head.next;
        size--;
        return q.data;
    }

    // 将数组元素加入
    public void addArray(T[] arr) {
        for(T t : arr) {
            add(t);
        }
    }

    // 获取头结点
    public T peek() {
        if(head == null) return null;
        return head.data;
    }

    // 获取尾节点
    public T tail() {
        if(tail == null) return null;
        return tail.data;
    }
}

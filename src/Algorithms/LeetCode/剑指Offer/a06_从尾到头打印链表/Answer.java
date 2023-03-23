package Algorithms.LeetCode.剑指Offer.a06_从尾到头打印链表;

import Algorithms.LeetCode.Node;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 19 23:06
 */
public class Answer extends Node {

    Node head;
    public Answer add(int data) {
        Node node = new Node(null, data);
        if(head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        return this;
    }

    private void tailToHead(Node node) {
        if(node != null) {
            tailToHead(node.next);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        answer.add(1).add(2).add(3).add(4).add(5);
        answer.tailToHead(answer.head);
    }
}

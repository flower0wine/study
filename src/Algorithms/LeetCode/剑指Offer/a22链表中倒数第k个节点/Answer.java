package Algorithms.LeetCode.剑指Offer.a22链表中倒数第k个节点;

import Algorithms.LeetCode.Node;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 28 12:34
 */
public class Answer extends Node {
    int length = 6;

    private Node answer(Node head, int k) {
        int i = 0;
        while (i < length - k) {
            i++;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        Node head = new Node(new Node(new Node(new Node(new Node(new Node(null, 6) , 5), 4), 3), 2), 1);
        Node node = answer.answer(head, 3);
        System.out.println(node.data);
    }
}

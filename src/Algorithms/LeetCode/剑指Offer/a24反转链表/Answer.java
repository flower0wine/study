package Algorithms.LeetCode.剑指Offer.a24反转链表;

import Algorithms.LeetCode.Node;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 28 12:42
 */
public class Answer extends Node {
    // 循环反转链表
    private Node answer(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node p, q = head.next;
        head.next = null;
        while (q != null) {
            p = q;
            q = q.next;
            p.next = head;
            head = p;
        }
        return head;
    }

    // 递归反转链表
    private Node answer1(Node node, Node pre) {
        if(node == null) return pre;
        Node res = answer1(node.next, node);
        node.next = pre;
        return res;
    }

    private void show(Node head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.data);
            if(head.next != null) {
                stringBuilder.append("->");
            }
            head = head.next;
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        Node head = new Node(new Node(new Node(new Node(new Node(new Node(null, 6), 5), 4), 3), 2), 1);
        Answer answer = new Answer();
        answer.show(head);
        Node node = answer.answer1(head, null);
        answer.show(node);
    }
}

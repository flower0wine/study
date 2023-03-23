package Algorithms.LeetCode.剑指Offer.a25合并两个排序的链表;

import Algorithms.LeetCode.Node;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 28 13:54
 */
public class Answer extends Node {
    private Node answer(Node link1, Node link2) {
        Node node;
        if(link1.data <= link2.data) {
            node = link1;
            link1 = link1.next;
        } else {
            node = link2;
            link2 = link2.next;
        }
        Node tail = node;
        while (link1 != null && link2 != null) {
            if(link1.data <= link2.data) {
                tail.next = link1;
                tail = tail.next;
                link1 = link1.next;
                tail.next = null;
            } else {
                tail.next = link2;
                tail = tail.next;
                link2 = link2.next;
                tail.next = null;
            }
        }
        while (link1 != null) {
            tail.next = link1;
            link1 = link1.next;
            tail = tail.next;
            tail.next = null;
        }
        while (link2 != null) {
            tail.next = link2;
            tail = tail.next;
            link2 = link2.next;
            tail.next = null;
        }
        return node;
    }

    private void show(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.data);
            if(node.next != null) {
                stringBuilder.append("->");
            }
            node = node.next;
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        Node link1 = new Node(new Node(new Node(new Node(new Node(null, 12), 8), 6), 2), 1);
        Node link2 = new Node(new Node(new Node(new Node(new Node(null, 10), 9), 4), 3), 1);
        Answer answer = new Answer();
        Node node = answer.answer(link1, link2);
        answer.show(node);
    }
}

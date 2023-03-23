package Algorithms.LeetCode.剑指Offer.a35复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Function
 * @Start_Time 2023 01 23 17:09
 */
public class Answer {

    private static class Node {
        Node next;
        Node random;
        Integer data;

        public Node() {}

        public Node(Integer data) {
            this.data = data;
        }
    }

    // 使用 Map 完成
    public Node answerByMap(Node node) {
        if(node == null) return null;
        Node temp = node;
        Map<Node, Node> map = new HashMap<>();  // 原链表节点为键, 新链表节点为值
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;
        }
        temp = node;
        while (temp.next != null) {
            Node n = map.get(temp);
            n.next = map.get(temp.next);    // 连接节点
            n.random = map.get(temp.random);    // 连接 random
            temp = temp.next;
        }
        return map.get(node);
    }

    public Node answerBySplice(Node node) {
        if(node == null) return null;
        Node temp = node, head, headTemp;
        while (temp != null) {  // 在原链表中插入新节点
            Node n = new Node(temp.data);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
        temp = node;
        // 将新节点 random 指针改变
        while (temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = node;
        head = temp.next;
        // 将新节点提取出来拼成一个新链表
        while (temp != null) {
            headTemp = temp.next;
            temp.next = temp.next.next;
            if(temp.next != null) { // 假设 temp 为第一个节点, temp.next.next（第三个节点）可能为 null
                headTemp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        Node node1 = new Node(7);
        Node node2 = new Node(3);
        Node node3 = new Node(1);
        Node node4 = new Node(0);
        Node node5 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node4.random = node3;
        node3.random = node5;
        Node node = answer.answerBySplice(node1);
        System.out.println(node);
    }
}

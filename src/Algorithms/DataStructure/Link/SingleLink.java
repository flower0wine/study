package Algorithms.DataStructure.Link;


import Algorithms.DataStructure.Stack.Stack;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 09 28 16:55
 * <p>
 * 单向链表
 */
public class SingleLink {
    private Node head;

    // 定义节点
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 创建链表
    private void createLink(int size) {
        if (size <= 0) {
            return;
        } else if (size == 1) {
            head = new Node(1);
        } else {
            head = new Node(1);
            Node node = head;
            for (int i = 2; i <= size; i++) {
                node.next = new Node(i);
                node = node.next;
            }
        }
    }

    // 展示链表
    private void showLink() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        Node node = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (node != null) {
            stringBuilder.append(node.data);
            node = node.next;
            if (node != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    // 倒转链表，while循环方式
    private void reverseLinkOfCircle() {
        Node p, q = head.next;
        head.next = null;
        while (q != null) {
            p = q;
            q = q.next;
            p.next = head;
            head = p;
        }
    }

    // 倒转链表，递归方式
    private Node reverseLinkOfRecursion(Node node) {
        if (node == null || node.next == null) return node;
        Node head = reverseLinkOfRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    // 从未到头打印单链表，不能反转链表，使用栈实现
    public void reversePrintLink() {
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (true){
            Node n = stack.pop();
            if(n == null){
                break;
            }
            // 这里的 n.next 是链表中的 节点,不是组成栈的节点
            if(n.next != null){
                stringBuilder.append(", ");
            }
            stringBuilder.append(n.data);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        singleLink.createLink(10);
        singleLink.showLink();
        singleLink.reversePrintLink();
        singleLink.showLink();
    }
}


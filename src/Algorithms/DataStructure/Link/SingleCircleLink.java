package Algorithms.DataStructure.Link;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 09 29 19:08
 * <p>
 * 单向循环链表
 */
public class SingleCircleLink {
    private Node head;
    private int size;

    class Node {
        int data;
        Node next;
    }

    // 创建单向循环链表
    public void createCircleLink(int size) {
        if (size <= 0) {
            return;
        }
        this.size = size;
        Node node;
        head = new Node();
        head.data = 1;
        if (size > 1) {
            node = head;
            for (int i = 2; i <= size; i++) {
                Node newNode = new Node();
                newNode.data = i;
                node.next = newNode;
                node = node.next;
            }
            node.next = head;
        } else {
            head.next = head;
        }
    }

    /**
     * 模拟约瑟夫问题
     *
     * @param m 数到 m 的人出列
     * @param k 从第 k 个人开始数
     */
    public void JosephQuestion(int m, int k) {
        if (head != null && m >= 1 && (k >= 1 && k <= size && head.next != null)) {
            Node node = head;
            while (node.next != head) {
                node = node.next;
            }
            for (int i = 1; i < k; i++) {
                node = node.next;
            }
            while (true) {
                for (int i = 1; i < m; i++) {
                    node = node.next;
                }
                // 当还有一个人的时候
                if (node == node.next) {
                    head = null;
                    System.out.println(node.data + "被移除");
                    break;
                }
                System.out.println(node.next.data + "被移除");
                node.next = node.next.next;
            }
        }
    }

    // 展示单向环形链表
    public void showCircleLink() {
        if (head == null) {
            return;
        }
        Node node = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        do {
            stringBuilder.append(node.data);
            node = node.next;
            if (node != head) {
                stringBuilder.append(", ");
            }
        } while (node != head);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        SingleCircleLink singleCircleLink = new SingleCircleLink();
        singleCircleLink.createCircleLink(2);
        singleCircleLink.showCircleLink();
        singleCircleLink.JosephQuestion(11, 1);
    }
}

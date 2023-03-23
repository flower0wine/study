package Algorithms.LeetCode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 30 15:40
 */
public class Node {
    public Node next;
    public int data;

    public Node() {
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
}

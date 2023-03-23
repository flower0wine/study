package Algorithms.DataStructure.Stack;

import java.util.Comparator;
import java.util.Objects;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 09 29 13:48
 *
 * 链式栈
 */
public class Stack<T> {
    Node<T> top;
    Node<T> bottom;

    static class Node<T> {
        // node 是存储数据的
        T data;
        Node<T> next;
    }

    // 判断栈为空
    public boolean isNull(){
        return bottom == null && top == null;
    }

    // 压栈
    public Stack<T> push(T data){
        Node<T> n = top;
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if(isNull()){
            top = bottom = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return this;
    }

    // 出栈
    public T pop(){
        if(!isNull()){
            // 当 top 与 bottom 相等时认为到达栈底，由于下一步要进行出栈操作，所以设置 bottom 为空
            if(top == bottom){
                bottom = null;
            }
            T node = top.data;
            top = top.next;
            return node;
        }
        return null;
    }

    // 返回栈顶
    public T peek() {
        if(top == null) return null;
        return top.data;
    }

    // 添加数组
    public void addArray(T[] arr) {
        for(T t : arr) {
            push(t);
        }
    }
}

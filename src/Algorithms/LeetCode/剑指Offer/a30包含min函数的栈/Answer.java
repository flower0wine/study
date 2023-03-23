package Algorithms.LeetCode.剑指Offer.a30包含min函数的栈;

import Algorithms.DataStructure.Stack.Stack;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 12 01 15:15
 */
public class Answer<T extends Comparable<T>> extends Stack<T> { // 特别注意：这里 T 要继承 Comparable, 为了能调用 T 自己的 compare 方法
    private Stack<T> stack = new Stack<>();

    @Override
    public Stack<T> push(T data) {
        if(stack.isNull()) {
            stack.push(data);
        } else {
            if(stack.peek().compareTo(data) > 0) {  // 使用 compareTo 方法将会调用类型 T 的 compare 方法
                stack.push(data);
            }
        }
        return super.push(data);
    }

    public T min() {
        return stack.pop();
    }

    public static void main(String[] args) {
        Answer<Integer> answer = new Answer<>();
        answer.push(-2).push(0).push(-3);
        Integer integer = answer.min();
        System.out.println(integer);
        answer.pop();
        System.out.println(answer.min());
    }
}

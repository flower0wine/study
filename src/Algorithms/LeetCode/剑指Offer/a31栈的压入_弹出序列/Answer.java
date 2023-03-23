package Algorithms.LeetCode.剑指Offer.a31栈的压入_弹出序列;

import Algorithms.DataStructure.Stack.Stack;

import java.util.Objects;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 12 04 9:25
 */
public class Answer {
    private boolean answer(Integer[] push, Integer[] pop) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        for(Integer i : push) {
            stack.push(i);
            while (!stack.isNull() && Objects.equals(stack.peek(), pop[n])) {
                stack.pop();
                n++;
            }
        }
        return stack.isNull();
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        Integer[] push = new Integer[]{1, 2, 3, 4, 5};
        Integer[] pop = new Integer[]{4, 5, 3, 2, 1};
        System.out.println(answer.answer(push, pop));
    }
}

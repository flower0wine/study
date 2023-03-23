package Algorithms.LeetCode.剑指Offer.a39数组中出现次数超过一半的数字;

import java.util.*;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Answer {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 2, 0, 0, };
        int x = 0, votes = 0;
        for(int num : arr) {
            if(votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        System.out.println(x);
    }
}

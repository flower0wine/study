package Algorithms.LeetCode.剑指Offer.a15二进制数中1的个数;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 20 22:56
 */
public class Answer {
    public static void main(String[] args) {
        int n = 11, sum = 0;
        while (n > 0) {
            if((n & 1) == 1) sum++;
            n = n >> 1;
        }
        System.out.println(sum);
    }
}

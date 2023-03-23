package Algorithms.LeetCode.剑指Offer.a10_青蛙跳台阶;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 17 21:51
 *
 * 青蛙跳台阶: 斐波纳挈[ f(n) = f(n - 1) + f(n - 2) ]
 */
public class Answer {

    public static int answer(int n) {
        int a = 1, b = 1, c;
        for(int i = 0; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            System.out.println(answer(i));
        }
    }
}

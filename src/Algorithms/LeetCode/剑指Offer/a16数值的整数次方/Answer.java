package Algorithms.LeetCode.剑指Offer.a16数值的整数次方;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 20 23:03
 */
public class Answer {

    private double answer(double x, int y) {
        if (y == 0) return 1.0;
        double d = 1.0;
        if(y < 0) {
            x = 1 / x;
        }
        for (int i = 0; i < Math.abs(y); i++) {
            d *= x;
        }
        return d;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        System.out.println(answer.answer(2.0, 2));
    }
}

package Algorithms.ClassicAlgorithms;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description 快速幂
 */
public class Counting {

    public static void main(String[] args) {
        long a = 22346, b = 123456;
        long res = 1;
        long l = System.currentTimeMillis();
        while (b > 0) {
            // 核心
            while (b % 2 == 0) {
                b /= 2;
                a = (a * a) % 10000;
            }
            b--;
            res = (res * a) % 10000;
        }
        System.out.println(res);
        long  l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

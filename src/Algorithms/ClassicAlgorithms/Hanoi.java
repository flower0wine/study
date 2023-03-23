package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 23 20:01
 * <p>
 * 汉诺塔
 */
public class Hanoi {

    public Hanoi(int n) {
        hanoi('A', 'B', 'C', n);
    }

    private void hanoi(char tower1, char tower2, char tower3, int n) {
        if (n == 0) {
            return;
        }
        hanoi(tower1, tower3, tower2, n - 1); // 将 n - 1 个从 tower1 移到 tower2
        System.out.println(tower1 + "->" + tower3); // 将第 n 个从 tower1 移到 tower3
        hanoi(tower2, tower1, tower3, n - 1); // 将 n - 1 个从 tower2 移到 tower3（结合具体个数更好理解）
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(3);
    }
}

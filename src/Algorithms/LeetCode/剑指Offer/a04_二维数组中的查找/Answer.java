package Algorithms.LeetCode.剑指Offer.a04_二维数组中的查找;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 19 22:50
 */
public class Answer {

    private boolean search(int[][] arr, int target) {
        int row = arr.length - 1, col = 0;
        while (row >= 0 && col < arr[row].length) {
            if(arr[row][col] > target) {
                row--;
            } else if(arr[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Answer answer = new Answer();
        boolean search = answer.search(arr, 5);
        System.out.println(search);
    }
}

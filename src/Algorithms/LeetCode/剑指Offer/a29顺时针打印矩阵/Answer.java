package Algorithms.LeetCode.剑指Offer.a29顺时针打印矩阵;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 12 01 14:09
 */
public class Answer {
    private void answer(int[][] arr) {
        int rowLength = arr.length - 1, colLength = arr[0].length - 1;
        int rowTop = 0, rowBottom = rowLength, colLeft = 0, colRight = colLength;
        while (true) {
            for(int i = colLeft; i <= colRight; i++) {
                System.out.println(arr[rowTop][i]);
            }
            if(rowBottom == rowTop) {
                break;
            }
            rowTop++;
            for(int i = rowTop; i <= rowBottom; i++) {
                System.out.println(arr[i][colRight]);
            }
            if(colLeft == colRight) {
                break;
            }
            colRight--;
            for(int i = colRight; i >= colLeft; i--) {
                System.out.println(arr[rowBottom][i]);
            }
            if(rowBottom == rowTop) {
                break;
            }
            rowBottom--;
            for(int i = rowBottom; i >= rowTop; i--) {
                System.out.println(arr[i][colLeft]);
            }
            if(colLeft == colRight) {
                break;
            }
            colLeft++;

        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Answer answer = new Answer();
        answer.answer(arr);
    }
}

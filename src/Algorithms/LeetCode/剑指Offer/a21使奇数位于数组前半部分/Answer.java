package Algorithms.LeetCode.剑指Offer.a21使奇数位于数组前半部分;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 28 12:26
 */
public class Answer {
    private void answer(int[] arr) {
        int i = 0, j = arr.length - 1, temp = arr[0];
        while (i < j) {
            while (i < j && arr[j] % 2 == 0) {   // 偶数在后
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] % 2 != 0) {   // 奇数在前
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Answer answer = new Answer();
        answer.answer(arr);
        System.out.println(Arrays.toString(arr));
    }
}

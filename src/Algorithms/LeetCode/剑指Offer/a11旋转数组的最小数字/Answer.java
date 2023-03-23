package Algorithms.LeetCode.剑指Offer.a11旋转数组的最小数字;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 20 21:43
 */
public class Answer {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 5, 5, 5, 5, 4, 5};

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left - right) / 2 + right;
            if(arr[mid] > arr[right]) { // 中间数大于最右边的数, 说明最小值在中间数右边
                left = mid + 1;
            } else if(arr[mid] < arr[right]) {   // 中间数小于最右边的数, 说明最小值在中间数位置或者其左边
                right = mid;
            } else {
                right--;
            }
        }
    }
}

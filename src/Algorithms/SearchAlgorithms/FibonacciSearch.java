package Algorithms.SearchAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 11 14:35
 *
 * 斐波那契查找
 */
public class FibonacciSearch {
    private int[] arr;

    // 初始化数组
    private void initialArray() {
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    private void initialArray(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    // 构建斐波那契数组
    private int[] getFibonacciArray(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for(int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    // 斐波那契查找
    private int sort(int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0;
        int[] fibonacci = getFibonacciArray(20);
        System.out.println(Arrays.toString(fibonacci));
        while (arr.length > fibonacci[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fibonacci[k]);  // 构建一个长度为 f[k] 的 temp 数组, 多出来的 0 全部用最大值填充
        for(int i = high + 1; i < temp.length; i++){
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + fibonacci[k] - 1;   // k 开始时总是 temp 数组的最后一个下标
            if(target < temp[mid]){ // f[k] = f[k-1] + f[k-2], 注意 f[k-1] 大于 f[k-2]
                high = mid - 1;
                k--;    // 取一个较大下标 f[k-1]
            } else if(target > temp[mid]){ // f[k] = f[k-1] + f[k-2],
                low = mid + 1;
                k -= 2; // 取一个较小下标 f[k-2]
            } else {
                return (mid <= high) ? mid : high;  // 由于使用的数组是 temp 数组, 当查找的值为数组最大值时，会取到 temp 数组的最大下标,
            }                                       // 这是错误的, 所以取最大值时取得是 high
        }
        return -1;
    }

    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        fibonacciSearch.initialArray();
        System.out.println(fibonacciSearch.sort(7));
    }
}

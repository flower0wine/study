package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 09 8:57
 * <p>
 * 归并排序
 */
public class MergeSort {
    private int[] arr;

    // 初始化数组
    private void initialArray() {
        arr = new int[]{4, 2, 5, 1, 7, 5, 0, 3};
    }

    private void initialArray(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
    }

    // 归并排序
    private void sort() {
        int[] temp = new int[arr.length];   // 中间数组
        // 该排序会将数组几个部分
        sortSplit(arr, 0, arr.length - 1, temp);
    }

    // 归并排序： 拆分
    private void sortSplit(int[] arr, int left, int right, int[] temp) {
        // 未被分割成一个元素时
        if (left < right) {
            int mid = left - (left - right) / 2;
            sortSplit(arr, left, mid, temp);    // 将数组分为两组, 左边再均分
            sortSplit(arr, mid + 1, right, temp);   // 右边再均分
            sortIntegrate(arr, left, mid, right, temp); // 合并
        }
    }

    // 归并排序: 合并
    private void sortIntegrate(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int index = 0;  // index 作为填充 temp 数组的下标
        while (index != right - left + 1) { // right - left - 1 是当前被切割部分的长度, 该条件还可以是 l <= mid && r <= right
            while (l <= mid && r <= right) {  // 对两个已经有序的部分进行大小比较, 小的入 temp 数组
                if(arr[l] < arr[r]){
                    temp[index++] = arr[l++];
                } else {
                    temp[index++] = arr[r++];
                }
            }
            while (l > mid && r <= right) { // 如果 l 管理的那一部分已经全部入数组, 并且 r 还有没有入数组的元素, 就将 r 后面的元素全部入数组, 因为 r 管理的部分可能有很多较大的数
                temp[index++] = arr[r++];
            }
            while (r > right && l <= mid) { // 同理
                temp[index++] = arr[l++];
            }
        }
        for (int i = left, j = 0; j < index; i++, j++) { // 将 temp 中的相应数字填充到 原数组的相应位置
            arr[i] = temp[j];
        }
    }

    private void showArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.initialArray(80000);
        long l = System.currentTimeMillis();
        mergeSort.sort();
        long l1 = System.currentTimeMillis();
        mergeSort.showArray();
        System.out.println(l1 - l);
    }
}

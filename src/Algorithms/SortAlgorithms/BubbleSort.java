package Algorithms.SortAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 06 9:35
 * <p>
 * 冒泡排序
 */
public class BubbleSort {

    private int[] num;

    private void initialArray(){
        num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    // 初始化数组
    private void initialArray(int n) {
        num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = (int)(Math.random() * 100000);
        }
    }

    // 进行排序
    private void sort() {
        int temp;
        boolean flag = true;
        for (int i = 0; i < num.length - 1; i++) { // 外层循环只需进行 n - 1 次即可
            // 减一的原因是 要将最左边的数移至最右边，只需进行 n - 1 次即可 . 减 i 的原因是最坏的情况就是最大（小）的数在左边（右边），每循环移动一次，较大的数都会确定
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                    flag = false;
                }
            }
            if (flag) { // 优化: 如果在某一次循环中没有移动任何元素，就说明已经顺序
                break;
            } else {
                flag = true;
            }
        }
    }

    // 展示数组
    private void showArray() {
        System.out.println(Arrays.toString(num));
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.initialArray(80000);
        long l = System.currentTimeMillis();
        bubbleSort.sort();
        bubbleSort.showArray();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

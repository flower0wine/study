package Algorithms.SearchAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 09 22:34
 * <p>
 * 二分查找
 */
public class BinarySearch {
    private int[] arr;

    // 初始化数组
    private void initialArray() {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10};
    }

    private void initialArray(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private String search(int target) {
        return packageIndex(searchRecursion(0, arr.length - 1, target), target);
    }

    // 当有多个目标值时，打包后输出
    private String packageIndex(int index, int target){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (index != -1) {
            while (index >= 0 && arr[index] == target){
                index--;
            }
            while (++index < arr.length && arr[index] == target){
                stringBuilder.append(index);
                if(index + 1 < arr.length && arr[index + 1] == target){
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // 二分查找： 递归查找
    private int searchRecursion(int left, int right, int target) {
        if (left <= right) {
            int mid = left - (left - right) / 2;
            if (arr[mid] < target) {
                return searchRecursion(mid + 1, right, target);
            } else if (arr[mid] > target) {
                return searchRecursion(left, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 二分查找: 循环查找
    private int searchCycle(int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left - (left - right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.initialArray();
        long l = System.currentTimeMillis();
        System.out.println(binarySearch.search(10));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

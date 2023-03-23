package Algorithms.SearchAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 10 23:16
 *
 * 插值查找
 */
public class InterpolationSearch {
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

    private String search(int target) {
        return packageIndex(search(0, arr.length - 1, target), target);
    }

    // 插值查找
    private int search(int left, int right, int target){
        if(left < right && target <= arr[arr.length - 1] && target >= arr[0]){
            int mid = left + (right -  left) * (target - arr[left]) / (arr[right] - arr[left]);
            if(arr[mid] < target) {
                return search(mid + 1, right, target);
            } else if(arr[mid] > target) {
                return search(left, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        interpolationSearch.initialArray();
        System.out.println(interpolationSearch.search(10));
    }
}

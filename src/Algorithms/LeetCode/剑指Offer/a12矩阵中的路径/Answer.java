package Algorithms.LeetCode.剑指Offer.a12矩阵中的路径;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 20 22:25
 */
public class Answer {

    private boolean search(char[][] arr, String word, int row, int col, int index) {
        if(row >= 0 && row < arr.length && col >= 0 && col < arr[row].length && index < word.length() && word.charAt(index) == arr[row][col]) {
            if(index == word.length() - 1) return true;
            arr[row][col] = '\0';
            boolean flag = search(arr, word, row - 1, col, index + 1) || search(arr, word, row + 1, col, index + 1) ||
                    search(arr, word, row, col - 1, index + 1) || search(arr, word, row, col + 1, index + 1);
            arr[row][col] = word.charAt(index);
            return flag;
        }
        return false;
    }

    private boolean search(char[][] arr, String word, int row, int col) {
        if(word.charAt(0) != arr[row][col]) return false;
        return search(arr, word, row, col, 0);
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        Answer answer = new Answer();

        boolean flag = false;
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++) {
                if(flag = answer.search(arr, word, row, col)) break;
            }
            if(flag) break;
        }
        System.out.println(flag);
    }
}

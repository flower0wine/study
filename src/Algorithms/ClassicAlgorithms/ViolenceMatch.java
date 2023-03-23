package Algorithms.ClassicAlgorithms;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 25 21:40
 * <p>
 * 暴力匹配
 */
public class ViolenceMatch {
    private String srcStr;
    private String matchStr;

    public ViolenceMatch(String srcStr, String matchStr) {
        this.srcStr = srcStr;
        this.matchStr = matchStr;
    }

    // 暴力匹配
    public int BfMatch() {
        if (srcStr.length() < matchStr.length()) {
            return -1;
        }
        char[] srcStr = this.srcStr.toCharArray();
        char[] matchStr = this.matchStr.toCharArray();
        for (int i = 0; i < srcStr.length; i++) {
            for (int j = 0; j < matchStr.length && srcStr[i + j] == matchStr[j]; ) { // 如果字符匹配成功
                j++; // 匹配下一个字符
                if (j == matchStr.length) { // 当到匹配字符串的尾部时
                    return i;
                }
                if (i + j >= srcStr.length) { // 当匹配字符串到被匹配的字符串尾部时
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ViolenceMatch violenceMatch = new ViolenceMatch("ABCDBBC ABCDAB ABCDABCDABDE", "ABCDABD");

        System.out.println(violenceMatch.BfMatch());
    }
}

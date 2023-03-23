package Algorithms.ClassicAlgorithms;

import java.util.Arrays;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 25 22:22
 * <p>
 * KMP 匹配
 */
public class KmpMatch {
    private String srcStr;
    private String matchStr;

    public KmpMatch(String srcStr, String matchStr) {
        this.srcStr = srcStr;
        this.matchStr = matchStr;
    }

    // KMP 匹配（自妍, 对于 ABADABADE 与 ABADABADABADE 这种字符串不能匹配成功）
    public int kmpMatch() {
        if (srcStr.length() < matchStr.length()) {   // 如果被匹配字符串长度小于匹配字符串
            return -1;
        }
        int t = 0;
        char[] srcStr = this.srcStr.toCharArray();
        char[] matchStr = this.matchStr.toCharArray();
        for (int i = 0; i < srcStr.length; ) {
            for (int j = 0; j < matchStr.length && srcStr[i + j] == matchStr[j]; ) { // 如果单个字符匹配成功
                j++;    // j++ 放在这里是为了在匹配成功后即时退出, 而不是通过循环条件的不正确而退出
                if (j == matchStr.length) {  // 匹配字符串结束就退出
                    return i;
                }
                if (i + j >= srcStr.length) {    // 当前下标 i 加上 j 大于被匹配字符串, 不可能匹配上
                    return -1;
                }
                if (srcStr[i + j] == matchStr[0]) {  // 发现匹配字符串的第一个字符, 如果这次匹配失败, 下次匹配就以下标 t 开始查找
                    t = i + j;
                }
            }
            i = t > i ? t : i + 1;  //
        }
        return -1;
    }


    public static void main(String[] args) {
        KmpMatch kmpMatch = new KmpMatch("ABADABADABADE", "ABADABADE");
    }

    // KMP 算法
    public static int KMP(String s, String t) {
        int i = -1;
        int j = -1;
        int[] next = getNext(t);
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length()) {
            return i - t.length();
        } else {
            return -1;
        }
    }

    // 获取匹配字符串的 next 数组
    public static int[] getNext(String t) {
        int[] next = new int[t.length()];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < t.length() - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (t.charAt(i) != t.charAt(j)) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }
}

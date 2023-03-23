package Algorithms.LeetCode.剑指Offer.a20表示数值的字符串;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 28 11:20
 */
public class Answer {

    private boolean answer(String s) {
        if(s != null && !s.trim().equals("")) {
            char[] chars = s.trim().toCharArray();
            boolean dot = false, hasE = false, isNum = false;
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] >= '0' && chars[i] <= '9') {
                    isNum = true;
                    continue;
                }
                if(chars[i] == '.') {
                    if(!dot && !hasE) { // 有 e 之后不能有小数点
                        if(isNum && i == chars.length - 1) {    // 如果满足这种格式： 23.  4.
                            return true;
                        }
                        dot = true;
                        isNum = false;
                    } else {
                        return false;   // 不能有两个小数点
                    }
                } else if(chars[i] == 'e' || chars[i] == 'E') {
                    if(!hasE && i != 0) {   // e 不能位于数字第一位
                        hasE = true;
                        isNum = false;
                    } else {
                        return false;   // 不能有两个 e
                    }
                } else if(chars[i] == '+' || chars[i] == '-') {
                    if(!(i == 0 || chars[i - 1] == 'e' || chars[i - 1] == 'E')) {   // 符号只能位于数字第一位, 或 e 后的第一位
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return isNum;   // 循环结束后根据 isNum 返回
        }
        return false;
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        boolean b = answer.answer("  .0");
        System.out.println(b);
    }
}

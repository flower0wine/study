package Algorithms.LeetCode.剑指Offer.a05_替换空格;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 19 23:02
 */
public class Answer {

    private String replace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        String s = answer.replace("We are happy");
        System.out.println(s);
    }
}

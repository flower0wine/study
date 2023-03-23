package Algorithms.LeetCode.剑指Offer.a34二叉树中和为某一值的路径;

import Algorithms.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Function
 * @Start_Time 2023 01 19 17:13
 */
public class Answer {

    private int targetNum;
    private List<Object> list = new ArrayList<>();

    public String answer() {
        TreeNode treeNode = new TreeNode(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(null, null, 7),
                                new TreeNode(null, null, 2),
                                11),
                        null,
                        4),
                new TreeNode(
                        new TreeNode(null, null, 13),
                        new TreeNode(
                                new TreeNode(null, null, 5),
                                new TreeNode(null, null, 1),
                                4),
                        8),
                5);
        int targetNum = 22;
        return answer(treeNode, targetNum);
    }

    public String answer(TreeNode treeNode, int targetNum) {
        if(treeNode != null) {
            this.targetNum = targetNum;
            recursion(treeNode, new ArrayList<>(), 0);
            return list.toString();
        }
        return "[]";
    }

    private void recursion(TreeNode treeNode, List<Integer> treeNodeList, int sum) {
        if(treeNode != null) {
            sum += treeNode.data;
            List<Integer> tempList = new ArrayList<>(treeNodeList);
            tempList.add(treeNode.data);
            if(treeNode.left == null && treeNode.right == null && sum == targetNum) {
                list.add(tempList);
                return;
            }
            if(treeNode.left != null) {
                recursion(treeNode.left, tempList, sum);
            }
            if(treeNode.right != null) {
                recursion(treeNode.right, tempList, sum);
            }
        }
    }

    public static void main(String[] args) {
        Answer answer = new Answer();
        System.out.println(answer.answer());
    }
}

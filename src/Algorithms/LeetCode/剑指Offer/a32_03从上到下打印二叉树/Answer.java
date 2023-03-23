package Algorithms.LeetCode.剑指Offer.a32_03从上到下打印二叉树;

import Algorithms.DataStructure.Queue.Queue;
import Algorithms.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 12 04 16:06
 */
public class Answer {

    private void answer(TreeNode treeNode) {
        Queue<TreeNode> queue = new Queue<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<TreeNode> list = new ArrayList<>();
        TreeNode tNode;
        boolean flag = true;

        if (treeNode != null) {
            list.add(treeNode);
        }
        stringBuilder.append("[\n");
        while (!list.isEmpty()) {
            stringBuilder.append("\t[");
            for (TreeNode t : list) {
                queue.add(t);
                stringBuilder.append(t.data);
                if (t != list.get(list.size() - 1)) {
                    stringBuilder.append(", ");
                }
            }
            list.clear();
            while (!queue.isEmpty()) {
                tNode = queue.remove();
                if (tNode == null) {
                    break;
                }
                if(flag) {
                    flag = false;
                    if (tNode.right != null) {
                        list.add(tNode.right);
                    }
                    if (tNode.left != null) {
                        list.add(tNode.left);
                    }
                } else {
                    flag = true;
                    if (tNode.left != null) {
                        list.add(tNode.left);
                    }
                    if (tNode.right != null) {
                        list.add(tNode.right);
                    }
                }
            }
            stringBuilder.append("],\n");
        }
        stringBuilder.append("]\n");
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(null, null, 9), new TreeNode(new TreeNode(null, null, 15), new TreeNode(null, null, 7), 20), 3);
        Answer answer = new Answer();
        answer.answer(treeNode);
    }
}

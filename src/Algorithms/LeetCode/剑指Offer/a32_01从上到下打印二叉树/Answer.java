package Algorithms.LeetCode.剑指Offer.a32_01从上到下打印二叉树;

import Algorithms.DataStructure.Queue.Queue;
import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 12 04 14:43
 */
public class Answer {
    private void answer(TreeNode treeNode) {
        Queue<TreeNode> queue = new Queue<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode t = queue.remove();
            if (t != null) {
                System.out.println(t.data);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(null, null, 9), new TreeNode(new TreeNode(null, null, 15), new TreeNode(null, null, 7), 20), 3);
        Answer answer = new Answer();
        answer.answer(treeNode);
    }
}

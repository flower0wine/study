package Algorithms.LeetCode.剑指Offer.a07_重建二叉树;

import Algorithms.LeetCode.TreeNode;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 11 17 22:25
 * <p>
 * 重建二叉树[ 通过前序遍历和中序遍历的结果, 只考虑每个数都不同 ]
 */
public class PreInOrder extends TreeNode {

    // 默认数据
    private int[] preOrder;
    private int[] inOrder;
    // 在 preOrder 中的索引
    private int preOrderIndex = 0;
    // 错误提示
    private String distinctTip = "前序遍历和中序遍历结果不是同一个树遍历的结果 preOrder[%d] = %d 和 inOrder[%d] = %d";
    private String distinctTree = "前序遍历与中序遍历不匹配, 前序遍历 preOrder[%d] = %d 无法在 inOrder 范围为 %d ~ %d 中找到";

    // 使用默认
    public TreeNode answer() {
        this.preOrder = new int[]{3, 5, 2, 4, 7, 0, 9};
        this.inOrder = new int[]{2, 5, 4, 3, 0, 7, 9};
        return answer(preOrder, inOrder);
    }

    public TreeNode answer(int[] preOrder, int[] inOrder) {
        if(inOrder != null && preOrder != null) {
            // 只有一个节点
            if(preOrder.length == inOrder.length && preOrder.length == 1) {
                if(preOrder[0] != inOrder[0]) {
                    throw new RuntimeException(String.format(distinctTip, 0, preOrder[0], 0, inOrder[0]));
                }
                return new TreeNode(preOrder[0]);
            } else {    // 多个节点
                this.inOrder = inOrder;
                this.preOrder = preOrder;
                return merge(0, inOrder.length - 1);
            }
        }
        // 前序、中序均为 null
        return new TreeNode();
    }

    // 创建并合并子二叉树
    private TreeNode merge(int left, int right) {
        if(left == right) {
            preOrderIndex++;
            return new TreeNode(inOrder[left]);
        } else {
            int index = searchDateInOrder(left, right);
            preOrderIndex++;
            TreeNode treeNode = new TreeNode(inOrder[index]);
            if(index > left) {
                treeNode.left = merge(left, index - 1);
            }
            if(index < right) {
                treeNode.right = merge(index + 1, right);
            }
            return treeNode;
        }
    }

    // 在指定范围内搜索 preOrder[preOrderIndex] 在 inOrder 中的下标
    private int searchDateInOrder(int left, int right) {
        for(int i = left; i <= right; i++) {
            if(inOrder[i] == preOrder[preOrderIndex]) {
                return i;
            }
        }
        throw new RuntimeException(String.format(distinctTree, preOrderIndex, preOrder[preOrderIndex], left, right));
    }

    public static void main(String[] args) {
        PreInOrder preInOrder = new PreInOrder();
        TreeNode treeNode = preInOrder.answer();
        System.out.println(treeNode);
    }
}

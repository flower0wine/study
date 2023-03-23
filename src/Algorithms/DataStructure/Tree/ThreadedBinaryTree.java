package Algorithms.DataStructure.Tree;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 16 9:38
 * <p>
 * 线索化二叉树
 */
public final class ThreadedBinaryTree<T> {
    private int size = 0;

    // 根节点
    private TreeNode<T> root;

    private static final class TreeNode<T> {
        private TreeNode<T> left;
        private TreeNode<T> right;
        private T data;
        private int leftType;
        private int rightType;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    // 创建空树
    public ThreadedBinaryTree() {
    }

    public int size() {
        return size;
    }

    // 添加树节点, 相同的值不会覆盖, 数据为 null 的节点也可以加入
    public ThreadedBinaryTree<T> put(T data) {
        TreeNode<T> t = root;
        int cmp = 0;
        TreeNode<T> parent = null;
        if (t == null) {
            root = new TreeNode<>(data);
            size++;
            return this;
        } else {
            Comparable<? super T> comparable = (Comparable<? super T>) data;
            while (t != null) {
                parent = t;
                cmp = comparable.compareTo(t.data);
                if (cmp > 0) {
                    t = t.right;
                } else if (cmp < 0) {
                    t = t.left;
                } else {
                    t.data = data;
                    return this;
                }
            }
        }
        if (cmp > 0) {
            parent.right = new TreeNode<>(data);
        } else {
            parent.left = new TreeNode<>(data);
        }
        size++;
        return this;
    }

    // 线索化二叉树
    public void clueBinaryTree() {
        // 前序
//        prefixClueBinaryTree(root);
        // 中序
        infixClueBinaryTree(root);
        // 后序
//        suffixClueBinaryTree(root);
    }

    private TreeNode<T> pre;

    // 前序线索化二叉树
    private void prefixClueBinaryTree(TreeNode<T> treeNode) {
        if (treeNode != null) {
            if (treeNode.left == null) {
                treeNode.left = pre;
                treeNode.leftType = 1;
            }
            if (pre != null && pre.right == null) {
                pre.right = treeNode;
                pre.rightType = 1;
            }
            // 在 treeNode 指向下一个节点后, pre 则指向它的前一个节点
            pre = treeNode;
            // 如果 treeNode 节点左节点是左子树, 不是前驱节点
            if (treeNode.leftType == 0) {
                prefixClueBinaryTree(treeNode.left);
            }
            // 不是后继节点
            if (treeNode.rightType == 0) {
                prefixClueBinaryTree(treeNode.right);
            }
        }
    }

    // 中序线索化二叉树
    private void infixClueBinaryTree(TreeNode<T> treeNode) {
        if (treeNode != null) {
            infixClueBinaryTree(treeNode.left);
            if (treeNode.left == null) {
                treeNode.left = pre;
                treeNode.leftType = 1;
            }
            if (pre != null && pre.right == null) {
                pre.right = treeNode;
                pre.rightType = 1;
            }
            pre = treeNode;
            infixClueBinaryTree(treeNode.right);
        }
    }

    // 后序线索化二叉树
    private void suffixClueBinaryTree(TreeNode<T> treeNode) {
        if (treeNode != null) {
            infixClueBinaryTree(treeNode.left);
            infixClueBinaryTree(treeNode.right);
            if (treeNode.left == null) {
                treeNode.left = pre;
                treeNode.leftType = 1;
            }
            if (pre != null && pre.right == null) {
                pre.right = treeNode;
                pre.rightType = 1;
            }
            pre = treeNode;
        }
    }

    // 遍历中序线索化二叉树
    public void infixList() {
        TreeNode<T> treeNode = root;
        while (treeNode != null) {
            while (treeNode.leftType == 0) {
                treeNode = treeNode.left;
            }
            System.out.println(treeNode.data);
            while (treeNode.rightType == 1) {
                treeNode = treeNode.right;
                System.out.println(treeNode.data);
            }
            treeNode = treeNode.right;
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTree<Integer> sequentialBinaryTree = new ThreadedBinaryTree<>();
        sequentialBinaryTree.put(5).put(2).put(7).put(1).put(3).put(6).put(8);
        sequentialBinaryTree.clueBinaryTree();
        sequentialBinaryTree.infixList();
    }
}

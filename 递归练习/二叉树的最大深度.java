package 递归练习;

/**
 * Created by Xiao Tao on 2020/3/9 13:28
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dp(root, 1);
        return max;
    }

    int max = 0;

    public void dp(TreeNode treeNode, int l) {
        if (treeNode == null) {
            return;
        }
        max = Math.max(max, l);
        dp(treeNode.left, l + 1);
        dp(treeNode.right, l + 1);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

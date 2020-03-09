package 树;

/**
 * Created by Xiao Tao on 2020/2/24 9:47
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        get(root, 1);
        return maxdeep;
    }

    int maxdeep = 0;

    public void get(TreeNode root, int deep) {
        maxdeep = maxdeep < deep ? deep : maxdeep;
        if (root.left != null) {
            get(root.left, deep + 1);
        }
        if (root.right != null) {
            get(root.right, deep + 1);
        }
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

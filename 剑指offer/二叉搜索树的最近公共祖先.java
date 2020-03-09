package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/13 13:34
 */
public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        二叉搜索树的最近公共祖先 s = new 二叉搜索树的最近公共祖先();
        System.out.println(s);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}

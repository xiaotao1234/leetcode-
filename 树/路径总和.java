package 树;

/**
 * Created by Xiao Tao on 2020/2/29 23:49
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return get(root,root.val,sum);
    }

    public boolean get(TreeNode node, int num, int sum) {
        if (node.left == null && node.right == null) {
            if (num == sum) {
                return true;
            } else {
                return false;
            }
        }
        boolean left = false, right = false;
        if (node.left != null) {
            left = get(node.left, num + node.left.val, sum);
        }
        if (node.right != null) {
            right = get(node.right, num + node.right.val, sum);
        }
        if (left == true || right == true) {
            return true;
        } else {
            return false;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

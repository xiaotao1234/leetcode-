package 双周赛21;

/**
 * Created by Xiao Tao on 2020/3/7 23:25
 */
public class 二叉搜索子树的最大键值和 {
    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = get(root.left, true, Integer.MIN_VALUE, root.val);
        }
        if (root.right != null) {
            right = get(root.right, false, root.val, Integer.MAX_VALUE);
        }
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
            max = Math.max(left + right + root.val, max);
        }
        max = max > 0 ? max : 0;
        return max;
    }

    int max = 0;

    public int get(TreeNode treeNode, boolean isleft, int left, int right) {
        if (treeNode == null) {
            return 0;
        }
        if (isleft) {
            if (treeNode.val > left && treeNode.val < right) {
                int leftall, rightall;
                leftall = get(treeNode.left, true, left, treeNode.val);
                rightall = get(treeNode.right, false, treeNode.val, right);
                if (leftall != Integer.MIN_VALUE && rightall != Integer.MIN_VALUE) {
                    max = Math.max(max, leftall + rightall + treeNode.val);
                    return leftall + rightall + treeNode.val;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                int leftall = get(treeNode.left, true, Integer.MIN_VALUE, treeNode.val);
                int rightall = get(treeNode.right, false, treeNode.val, Integer.MAX_VALUE);
                if (leftall != Integer.MIN_VALUE && rightall != Integer.MIN_VALUE) {
                    int all = leftall + rightall + treeNode.val;
                    max = Math.max(max, all);
                }
                return Integer.MIN_VALUE;
            }
        } else {
            if (treeNode.val > left && treeNode.val < right) {
                int leftall = get(treeNode.left, true, left, treeNode.val);
                int rightall = get(treeNode.right, false, treeNode.val, right);
                if (leftall != Integer.MIN_VALUE && rightall != Integer.MIN_VALUE) {
                    max = Math.max(max, leftall + rightall + treeNode.val);
                    return leftall + rightall + treeNode.val;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                int leftall = get(treeNode.left, true, Integer.MIN_VALUE, treeNode.val);
                int rightall = get(treeNode.right, false, treeNode.val, Integer.MAX_VALUE);
                if (leftall != Integer.MIN_VALUE && rightall != Integer.MIN_VALUE) {
                    int all = leftall + rightall + treeNode.val;
                    max = Math.max(max, all);
                }
                return Integer.MIN_VALUE;
            }
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

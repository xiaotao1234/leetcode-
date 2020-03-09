package 树;

/**
 * Created by Xiao Tao on 2020/2/24 10:19
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return get(root, null, null);
    }


    public boolean get(TreeNode treeNode, Integer left, Integer right) {
        if (treeNode == null) return true;
        int val = treeNode.val;
        if (left != null && val <= left) return false;
        if (right != null && val >= right) return false;
        if (!get(treeNode.left, left, val)) return false;
        if (!get(treeNode.right, val, right)) return false;
        return true;
//            if (treeNode.left != null) {
//                if (treeNode.left.val < treeNode.val && (treeNode.left.val > left)) {
//                    get(treeNode.left, left, treeNode.val);
//                } else {
//                    is = false;
//                }
//            }
//        if (treeNode.right != null) {
//            if (treeNode.right.val > treeNode.val && treeNode.right.val < right) {
//                get(treeNode.right, treeNode.val, right);
//            } else {
//                is = false;
//            }
//        }
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

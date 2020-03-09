package 树;

/**
 * Created by Xiao Tao on 2020/2/24 9:52
 */
public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        get(root, root);
        return is;
    }

    boolean is = true;

    public void get(TreeNode treeNode, TreeNode treeNode1) {
        if (treeNode != null && treeNode1 != null) {
            if (treeNode.val != treeNode1.val) {
                is = false;
            } else {
                get(treeNode.left, treeNode1.right);
                get(treeNode.right, treeNode1.left);
            }
        } else if ((treeNode != null && treeNode1 == null) || (treeNode == null && treeNode1 != null)) {
            is = false;
        }
    }

    public boolean isSymmetric1(TreeNode root) {//练习
        if(root==null){
            return true;
        }
        return get1(root.left, root.right);
    }

    public boolean get1(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 != null && treeNode2 != null) {
            if (treeNode1.val != treeNode2.val) {
                return false;
            } else {
                return (get1(treeNode1.left, treeNode2.right) &&
                        get1(treeNode1.right, treeNode2.left));
            }
        } else if ((treeNode1 == null && treeNode2 != null) || (treeNode1 != null && treeNode2 == null)) {
            return false;
        }
        return true;
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

package 树;

/**
 * Created by Xiao Tao on 2020/2/24 10:12
 */
public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        get(p, q);
        return is;
    }

    boolean is = true;

    public void get(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                is = false;
            } else {
                get(p.left, q.left);
                get(p.right, q.right);
            }
        } else if ((p == null && q != null) || (p != null && q == null)) {
            is = false;
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

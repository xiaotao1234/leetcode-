package 递归练习;

/**
 * Created by Xiao Tao on 2020/2/20 13:25
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 结果为：2
 */
public class 最长同值路径 {
    public static void main(String[] args) {
        最长同值路径 s1 = new 最长同值路径();
        System.out.println(s1);
    }

    int max = 0;

//    public int longestUnivaluePath1(TreeNode root) {
//        if(root.left)
//    }

    public int longestUnivaluePath(TreeNode root) {//关键点：最大长度在每个节点计算时进行比较判定，递归每次向上只返回当前节点左右的最大长度
        if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.val == root.left.val && root.val == root.right.val) {
            int left = longestUnivaluePath(root.left);
            int right = longestUnivaluePath(root.right);
            max = left + right + 2 > max ? left + right + 2 : max;
            return left > right ? left + 1 : right + 1;
        } else if (root.val == root.right.val) {
            int rihght = longestUnivaluePath(root.right);
            max = rihght + 1 > max ? rihght + 1 : max;
        } else if (root.val == root.left.val) {
            int left = longestUnivaluePath(root.left);
            max = left + 1 > max ? left + 1 : max;
        } else {
            return 0;
        }
        return 0;
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

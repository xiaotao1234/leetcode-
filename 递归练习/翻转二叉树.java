package 递归练习;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/20 10:02
 * 反转二叉树 将左边的二叉树反转成右边的二叉树
 */
public class 翻转二叉树 {
    public static void main(String[] args) {
        翻转二叉树 s1 = new 翻转二叉树();
        System.out.println(s1);
    }

    public TreeNode get(TreeNode node) {
        if (node == null) {//此分支到达了根节点
            return null;//此分支的递归开始回升
        }
        TreeNode left = get(node.left);//对当前节点的左分支进行翻转
        TreeNode right = get(node.right);//对当前节点的右分支进行翻转
        node.left = right;//将当前节点的左分支放到当前节点的右边，对当前节点的左右分支进行翻转
        node.right = left;
        return node;//对翻转完成的节点返回给其父节点
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}

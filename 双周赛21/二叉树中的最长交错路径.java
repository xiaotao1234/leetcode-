package 双周赛21;

import 双指针.两数之和;

/**
 * Created by Xiao Tao on 2020/3/7 22:59
 */
public class 二叉树中的最长交错路径 {

    public static void main(String[] args) {
        二叉树中的最长交错路径 s1 = new 二叉树中的最长交错路径();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(1);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode5.right = treeNode7;
        treeNode7.right = treeNode8;
        System.out.println(s1.longestZigZag(treeNode1));
    }

    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left!=null){
            get(root.left,true,1);
        }
        if(root.right!=null){
            get(root.right,false,1);
        }
        return max;
    }

    int max = 0;

    public void get(TreeNode treeNode, boolean isLeft, int length) {
        if (isLeft) {
            if (treeNode.right != null) {
                get(treeNode.right, false, length + 1);
                if (treeNode.left != null) {
                    get(treeNode.left, true, 1);
                }
            } else {
                max = Math.max(max, length);
                if (treeNode.left != null) {
                    get(treeNode.left, true, 1);
                }

            }
        } else {
            if (treeNode.left != null) {
                get(treeNode.left, true, length + 1);
                if (treeNode.right != null) {
                    get(treeNode.right, false, 1);
                }
            } else {
                max = Math.max(max, length);
                if (treeNode.right != null) {
                    get(treeNode.right, false, 1);
                }
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

package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Xiao Tao on 2020/2/24 14:54
 */
public class 迭代法的树的中序遍历 {
    public static void main(String[] args) {
        迭代法的树的中序遍历 s = new 迭代法的树的中序遍历();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        s.get(treeNode);
        System.out.println(s.list);
    }

    List<TreeNode> list = new ArrayList<>();

    public void get(TreeNode treeNode) {//二叉树的迭代中序遍历

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node);
            node = node.right;
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

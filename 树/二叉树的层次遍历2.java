package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Xiao Tao on 2020/2/24 23:02
 */
public class 二叉树的层次遍历2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        get(root, 0);
        List<List<Integer>> listss = new ArrayList<>();
        for (List<Integer> list : lists) {
            listss.add(0, list);
        }
        return listss;
    }

    public void get(TreeNode treeNode, int deep) {
        if (treeNode == null) return;
        else {
            if (deep <= lists.size() && lists.get(deep) != null) {
                lists.get(deep).add(treeNode.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(treeNode.val);
                lists.add(deep, list);
            }
        }
        get(treeNode.left, deep + 1);
        get(treeNode.right, deep + 1);
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue1.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue1.add(treeNode.right);
            }
        }
        return new ArrayList<>();
    }
}

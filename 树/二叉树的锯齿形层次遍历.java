package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Xiao Tao on 2020/2/24 7:59
 */
public class 二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        二叉树的锯齿形层次遍历 s = new 二叉树的锯齿形层次遍历();
        System.out.println(s);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> treeNodeList1 = new ArrayList<>();
        treeNodeList.add(root);
        boolean order = true;
        while (treeNodeList.size() != 0) {
            int ir = treeNodeList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ir; i++) {
                TreeNode treeNode;
                if (order) {
                    treeNode = treeNodeList.remove(0);
                    if (treeNode.left != null) {
                        treeNodeList1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodeList1.add(treeNode.right);
                    }
                } else {
                    treeNode = treeNodeList.remove(treeNodeList.size() - 1);
                    if (treeNode.right != null) {
                        treeNodeList1.add(0, treeNode.right);
                    }
                    if (treeNode.left != null) {
                        treeNodeList1.add(0, treeNode.left);
                    }
                }
                list.add(treeNode.val);
            }
            order = !order;
            treeNodeList.clear();
            treeNodeList.addAll(treeNodeList1);
            treeNodeList1.clear();
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {//双栈
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (stack1.size() != 0 || stack2.size() != 0) {
            List<Integer> list = new ArrayList<>();
            if (stack1.size() != 0) {
                while (stack1.size()!=0) {
                    TreeNode treeNode = stack1.pop();
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                    }
                    list.add(treeNode.val);
                }
                lists.add(new ArrayList<>(list));
                list.clear();
            } else {
                while (stack2.size()!=0) {
                    TreeNode treeNode = stack2.pop();
                    if (treeNode.right != null) {
                        stack1.push(treeNode.right);
                    }
                    if(treeNode.left!=null){
                        stack1.push(treeNode.left);
                    }
                    list.add(treeNode.val);
                }
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
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

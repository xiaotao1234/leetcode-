package 树;

import 周赛171.将整数转换为两个无零整数的和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Xiao Tao on 2020/2/18 13:10
 */
public class 特定深度节点链表 {
    public static void main(String[] args) {
        特定深度节点链表 s = new 特定深度节点链表();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        System.out.println(s.listOfDepth(treeNode1));
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<TreeNode> listNodes = new ArrayList<>();
        List<TreeNode> listNodes1 = new ArrayList<>();
        List<ListNode> listNodes2 = new ArrayList<>();
        listNodes.add(tree);
        while (listNodes != null) {
            listNodes1.clear();
            ListNode listNode = new ListNode(0);//头节点
            ListNode listNode1 = listNode;//当前节点
            for (TreeNode treeNode : listNodes) {
                if (treeNode.left != null) {
                    listNode1.next = new ListNode(treeNode.val);
                    listNode1 = listNode1.next;
                    listNodes1.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    listNode1.next = new ListNode(treeNode.val);
                    listNode1 = listNode1.next;
                    listNodes1.add(treeNode.right);
                }
            }
            listNodes2.add(listNode);
            listNodes.clear();
            listNodes = listNodes1;
        }
        ListNode[] listNodes3 = new ListNode[listNodes2.size()];
        int i = 0;
        for(ListNode listNode:listNodes2){
            listNodes3[i] = listNode;
            i++;
        }
        return listNodes3;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

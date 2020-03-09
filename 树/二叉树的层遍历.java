package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Xiao Tao on 2020/2/23 23:10
 */
public class 二叉树的层遍历 {
    public static void main(String[] args) {
        二叉树的层遍历 s = new 二叉树的层遍历();
        System.out.println(s);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        list.add(root);
        while (list.size() != 0) {
            int size = list.size();
            List<Integer> listtem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.remove(0);
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
                listtem.add(treeNode.val);
            }
            lists.add(listtem);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }



    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {//递归的层序遍历
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }



//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-ci-bian-li-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

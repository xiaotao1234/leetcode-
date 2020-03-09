package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/13 10:16
 */
public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        二叉树的最近公共祖先 s = new 二叉树的最近公共祖先();
        System.out.println(s);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        treeNodeList.add(root);
        while (treeNodeList != null) {
            List<TreeNode> treeNodeListTem = new ArrayList<>();
            for (TreeNode treeNode : treeNodeList) {
                if (treeNode.left != null) {
                    treeNodeListTem.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeListTem.add(treeNode.right);
                }
            }
            treeNodeList.clear();
            treeNodeList.addAll(treeNodeListTem);
            treeNodeListTem.clear();
        }
        return treeNodeList.get(1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//诸如这种二叉树的问题，在从上到下遍历后，还需要从下到上反序进行回溯，则使用递归，依靠系统的压栈来帮我们记录正序遍历的顺序。
        // 在递归的回升时就可以做到逆序回升，对于树，其对每个节点可以做到最多三次，最少两次的访问。
        if (root == null || root == p || root == q) {//若当前节点为空则返回当前节点，其含义为返回null；或当前节点等于目标节点，则返回当前节点，
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);//对当前节点的左子树进行对两个目标节点的查找
        TreeNode right = lowestCommonAncestor(root.right, p, q);//对当前节点的右子树进行对两个目标节点的查找
        if (left != null && right != null) {//若左子树找到一个目标节点，且右子树也找到一个目标节点，则返回他们的根节点，（这里这道题能这样做的前提条件是树中一定存在且只存在唯一的目标节点p,q）
            return root;
        }
        return left == null ? right : left;//返回当前节点的左右子树中不为空的节点（返回找到了目标节点的那个子树），若都为空，则返回null（两个子树均未找到目标节点）
    }
    //整体思想就是在递归回升的时候，若出现目标节点，则返回目标节点，回升会将这个节点回升到目标节点的上一层即目标节点的父节点，
    // 而上一层的处理策略是若此层的左右子树都能返回不为空的节点，即都能发现目标节点（因为节点有且只有两个），那么代表目标节点
    // 分别位于这个节点的左右子树，即左右子树都分别有一个节点，此时的当前节点就为最小根节点。当然这时的递归回升可能并没有完成，
    // 但是只有节点的左右节点同时发现目标节点才能替换掉我们确定的最小根节点，当然这是不可能的，即一旦找到最小根节点，这个节点就会被回升传递到最终的返回
}

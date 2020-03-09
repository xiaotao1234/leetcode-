package 树;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/2/24 11:11
 */
public class 恢复二叉搜索树 {
    List<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        get(root);
        TreeNode treeNodetem = null;
        TreeNode last = null;
        for (TreeNode treeNode : list) {
            if (last == null && treeNodetem != null && treeNode.val < treeNodetem.val) {
                last = treeNodetem;
                treeNodetem = treeNode;
            } else if (last != null && treeNode.val < treeNodetem.val) {
                int value = treeNode.val;
                treeNode.val = last.val;
                last.val = value;
            } else {
                treeNodetem = treeNode;
            }
        }

    }

    public void get(TreeNode treeNode) {
        if (treeNode != null) {
            get(treeNode.left);
            list.add(treeNode);
            get(treeNode.right);
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


    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree1(TreeNode root) {//递归解法

        in_order(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(TreeNode root) {
        if (root == null) return;
        in_order(root.left);
        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
        if (firstNode != null && preNode.val > root.val) secondNode = root;//其相比我的做法，巧妙的地方在于其在两个交换的数恰好是两个相临的数时，
        // 也能一遍就记录下来，因为其有两个记录点，其在第一次找到目标位置时，会先将两个数都记录下来
        // 若后面没有再找到，那么第一次找到的两个数就是目标数
        // 若后面找到了，更新第二个记录点，其之所以能实现空间复杂度为一是因为其使用了递归依靠系统压栈来记录各个节点的值，
        // 其本质上来说其实时间复杂度为N，但是由于通常系统自动压栈而自动保存下来的值不计入时间复杂度的计算（没有主动申请，而是系统为了压栈和现在恢复而记录下来的值），这是一种减少时间复杂度的小技巧
        preNode = root;
        in_order(root.right);
    }


    public void recoverTree2(TreeNode root) {//迭代解法
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null && pre.val > p.val) firstNode = pre;
            if (firstNode != null && pre.val > p.val) secondNode = p;
            pre = p;
            p = p.right;
        }
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

//    作者：powcai
//    链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//    作者：powcai
//    链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

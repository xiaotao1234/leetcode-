package 递归练习;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/9 14:26
 */
public class 不同的二叉搜索树2 {
    public List<TreeNode> generateTrees(int n) {
        return dp(0, n - 1);
    }


    public List<TreeNode> dp(int left, int right) {
        if (left > right) {
            return null;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            for (TreeNode treeNode : dp(left, i - 1)) {
                for (TreeNode treeNode2 : dp(i + 1, right)) {
                    TreeNode treeNode1 = new TreeNode(i);
                    treeNode1.left = treeNode;
                    treeNode1.right = treeNode2;
                    treeNodeList.add(treeNode1);
                }
            }
        }
        return treeNodeList;
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

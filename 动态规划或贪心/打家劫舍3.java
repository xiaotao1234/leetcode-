package 动态规划或贪心;

import java.util.HashMap;
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/house-robber-iii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 打家劫舍3 {
    public static void main(String[] args) {
        打家劫舍3 s = new 打家劫舍3();
    }

    HashMap<TreeNode,Integer> hashMap = new HashMap<>();

    public int rob(TreeNode root) {
        return dpMethod(root);
    }

    public int dpMethod(TreeNode treeNode){ //解题思路，关键点是当求treenode为根节点的最大值时，有两种可能的取值
        //自身加上左右子树的子节点/不加自身则取左右子树
        //比较二者的最大的取值
        if(treeNode==null){
            return 0;
        }
        if(hashMap.containsKey(treeNode)){
            return hashMap.get(treeNode);
        }
        int dois = Math.max(treeNode.val+(treeNode.left==null?0:(dpMethod(treeNode.left.left)+dpMethod(treeNode.left.right)))+(treeNode.right==null?0:(dpMethod(treeNode.right.left)+dpMethod(treeNode.right.right))),
                dpMethod(treeNode.left)+dpMethod(treeNode.right));
        hashMap.put(treeNode,dois);
        return dois;
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

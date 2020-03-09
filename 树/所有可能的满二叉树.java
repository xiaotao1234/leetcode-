package 树;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/3/1 23:14
 */
public class 所有可能的满二叉树 {
//    public List<TreeNode> allPossibleFBT(int N) {
//
//    }

    List<TreeNode> list = new ArrayList<>();

//    public void get(TreeNode treeNode, int n, TreeNode current) {
//        if (n == 0) {
//            list.add(treeNode);
//        }else {
//            if (n - 2 >= 0) {
//                TreeNode treeNodeLeft = new TreeNode(0);
//                TreeNode treeNodeRight = new TreeNode(0);
//                current.left = treeNodeLeft;
//                current.right = treeNodeRight;
//                get(treeNode, n - 2, treeNodeLeft);
//                get(treeNode, n - 2, treeNodeRight);
//            }
//
//        }
//    }

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }

    public List<TreeNode> allPossibleFBT1(int N) {
        if (!memo.containsKey(N)) {//若已经在记录数组里包含了N个节点的List集合则直接返回不再做重复运算
            List<TreeNode> list = new ArrayList<>();
            if (N == 1) {
                list.add(new TreeNode(0));
            } else if (N % 2 == 1) {//为单节点才能成为满二叉树，否者跳过
                for (int i = 0; i < N; ++i) {//对左右子树的数量进行情况的遍历
                    int j = N - 1 - i;
                    //对左右每一种数量分配情况进行其组合可能性的列举

                    for (TreeNode left : allPossibleFBT1(i))//左子树的数量，因为在第一次遍历后会做记录所以多次访问效率下降的可以接受
                        for (TreeNode right : allPossibleFBT1(j)) {//右边子树的数量
                            TreeNode treeNode = new TreeNode(0);//生成一个当前树的根节点
                            treeNode.left = left;//将左子树加到根节点的左
                            treeNode.right = right;//将右子树加到根节点的右
                            list.add(treeNode);//在连接上左右子树后，将当前根节点就作为拥有N个元素数目的树存储到链表中，一个链表保存了拥有N个节点树的所有可能的满二叉树的组合情况
                        }
                }
            }
            memo.put(N, list);
        }
        return memo.get(N);
    }

    public List<TreeNode> allPossibleFBT11(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> list = new ArrayList<>();
            if (N == 1) {
                list.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int i = 0; i < N; ++i) {
                    int j = N - i - 1;
                    for (TreeNode left : allPossibleFBT11(i))
                        for (TreeNode right : allPossibleFBT11(j)) {
                            TreeNode treeNode = new TreeNode(0);
                            treeNode.left = left;
                            treeNode.right = right;
                            list.add(treeNode);
                        }
                }
            }
            memo.put(N, list);
        }
        return memo.get(N);
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees/solution/suo-you-ke-neng-de-man-er-cha-shu-by-leetcode/
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

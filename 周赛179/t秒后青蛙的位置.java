package 周赛179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/8 11:17
 */
public class t秒后青蛙的位置 {
    public static void main(String[] args) {
        t秒后青蛙的位置 s = new t秒后青蛙的位置();
        System.out.println(s.frogPosition(3, new int[][]{{1, 2}, {3, 2}}, 1, 2));
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        TreeNode treeNode = new TreeNode(1, 1);
        get(treeNode, edges, 0, target, 1, t);
        double l = 1;
        if (ll == 0) {
            return 0;
        }
        return l / ll;
    }

    int ll = 0;

    public void get(TreeNode treeNode, int[][] edges, int begin, int target, int t, int tt) {
        if (begin == edges.length) {
            return;
        }
        while (edges[begin][0] != treeNode.value) {
            begin++;
            if (begin == edges.length) {
                return;
            }
        }
        while (edges[begin][0] == treeNode.value) {
            TreeNode treeNode1 = new TreeNode(edges[begin][1], 1);
            treeNode.add(treeNode1);
            begin++;
            if (begin == edges.length) {
                return;
            }
        }
        for (TreeNode treeNode1 : treeNode.treeNodeList) {
            if (treeNode1.value == target && t <= tt) {
                ll = treeNode.gailu*treeNode.treeNodeList.size();
            } else {
                treeNode1.setGailu(treeNode.treeNodeList.size() * treeNode.gailu);
                get(treeNode1, edges, begin, target, t + 1, tt);
            }

        }
    }

    class TreeNode {
        List<TreeNode> treeNodeList;

        public int getValue() {
            return value;
        }

        int value;

        public void setGailu(int gailu) {
            this.gailu = gailu;
        }

        int gailu;

        public TreeNode(int value, int gailu) {
            this.value = value;
            this.gailu = gailu;
            treeNodeList = new ArrayList<>();
        }

        public void add(TreeNode treeNode) {
            treeNodeList.add(treeNode);
        }
    }
}

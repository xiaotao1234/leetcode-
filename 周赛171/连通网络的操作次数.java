package 周赛171;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class 连通网络的操作次数 {
    public static void main(String[] args) {
        连通网络的操作次数 s = new 连通网络的操作次数();
        System.out.println(s.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int[] s : connections) {
            if (!list.contains(s[0])) {
                list.add(s[0]);
            }
            if (!list.contains(s[1])) {
                list.add(s[1]);
            }
        }
        return n - list.size();
    }
}

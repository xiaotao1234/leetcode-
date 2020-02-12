package 其他;

import 动态规划或贪心.一和零;

/**
 * Created by Xiao Tao on 2020/2/11 15:57
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class 接雨水 {
    public static void main(String[] args) {
        接雨水 s = new 接雨水();
        System.out.println(s.trap(new int[]{5, 2, 1, 2, 1, 5}));
    }

    public int trap(int[] height) {//解法一：按行求
        boolean comeMax = false;
        int all = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (comeMax == true) {
                break;
            }
            int temp = 0;
            boolean start = false;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i && start == false) {
                    comeMax = true;
                    start = true;
                } else if (height[j] >= i && start == true && temp != 0) {
                    comeMax = true;
                    all = all + temp;
                    temp = 0;
                    start = false;
                } else if (height[j] < i && start == true) {
                    temp = temp + 1;
                }
            }
            if (comeMax == true) {
                comeMax = false;
            } else {
                comeMax = true;
            }
        }
        return all;
    }

    public int getmax(int[] height, int left, int right) {
        if (left + 1 == right) {
            return -1;
        }
        int max = 0;
        int index = left + 1;
        for (int i = left + 1; i < right; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        return index;
    }
}

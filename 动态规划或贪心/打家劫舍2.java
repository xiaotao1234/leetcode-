package 动态规划或贪心;

import java.util.Arrays;

public class 打家劫舍2 {
    public static void main(String[] args) {
        打家劫舍2 s = new 打家劫舍2();
        System.out.println(s.rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob1(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = nums[0];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/24 16:22
 */
public class 按摩师 {


    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = nums[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
        }
        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);
    }
}

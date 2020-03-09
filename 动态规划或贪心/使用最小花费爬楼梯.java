package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/6 23:51
 */
public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length + 1; i++) {
            if (i == 0) {
                dp[0] = cost[0];
            } else if (i == 1) {
                dp[1] = cost[1];
            } else if (i == cost.length) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
            }
        }
        return dp[cost.length];
    }
}

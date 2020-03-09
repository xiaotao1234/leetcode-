package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/4 23:35
 */
public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];//状态0表示未持有，状态1表示持有，状态2表示冻结
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                dp[i][2] = 0;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }
        return dp[prices.length - 1][0];
    }
}

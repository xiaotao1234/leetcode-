package 每日一题;

/**
 * Created by Xiao Tao on 2020/3/9 8:40
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i][0]);
                dp[i][1] = Math.max(dp[i - 1][1],   - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/29 9:03
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length-1][0];
    }
}

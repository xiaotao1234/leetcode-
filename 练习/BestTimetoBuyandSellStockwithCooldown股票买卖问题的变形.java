package 练习;

/**
 * Created by Xiao Tao on 2020/2/10 11:03
 */
public class BestTimetoBuyandSellStockwithCooldown股票买卖问题的变形 {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown股票买卖问题的变形 s1 = new BestTimetoBuyandSellStockwithCooldown股票买卖问题的变形();
        System.out.println(s1.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
                dp[i][2] = dp[i - 1][0];
            }
        }
        return dp[prices.length - 1][0];
    }
}

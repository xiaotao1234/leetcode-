package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/13 14:03
 */
public class 股票的最大利润 {//一次股票买卖最大利润

    public static void main(String[] args) {
        股票的最大利润 s = new 股票的最大利润();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                int s = Math.max(dp[i][0], dp[i][1]);
                max = Math.max(s,max);
            } else {
                dp[i][0] = Math.max(0, dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                int s = Math.max(dp[i][0], dp[i][1]);
                max = Math.max(s,max);
            }
        }
        return max;
    }
}

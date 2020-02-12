package 练习;

/**
 * Created by Xiao Tao on 2020/1/17 15:02
 */
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        买卖股票的最佳时机2 s1 = new 买卖股票的最佳时机2();
        System.out.println(s1.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}

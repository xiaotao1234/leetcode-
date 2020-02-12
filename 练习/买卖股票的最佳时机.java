package 练习;

/**
 * Created by Xiao Tao on 2020/1/17 14:41
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        买卖股票的最佳时机 s1 = new 买卖股票的最佳时机();
        System.out.println(s1.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[prices.length-1];
        for(int i = 1;i<prices.length;i++){
            if(dp[i][0]==0){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
            }
        }
        return dp[prices.length-1][0];
    }
}

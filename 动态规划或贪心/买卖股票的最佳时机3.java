package 动态规划或贪心;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 买卖股票的最佳时机3 {
    public static void main(String[] args) {
        买卖股票的最佳时机3 s = new 买卖股票的最佳时机3();
        System.out.println(s.maxProfit(new int[]{1,2,3,4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] pd = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                pd[i][1][0] = 0;
                pd[i][1][1] = -prices[0];
                pd[i][2][0] = 0;
                pd[i][2][1] = -prices[0];
                continue;
            }
            pd[i][2][0] = Math.max(pd[i - 1][2][1] + prices[i], pd[i - 1][2][0]);
            pd[i][2][1] = Math.max(pd[i - 1][2][1], pd[i - 1][1][0] - prices[i]);
            pd[i][1][0] = Math.max(pd[i - 1][1][0], pd[i - 1][1][1] + prices[i]);
            pd[i][1][1] = Math.max(pd[i - 1][1][1], -prices[i]);
        }
        return pd[prices.length - 1][2][0];
    }

    int maxProfit_k_2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

}

package 动态规划或贪心;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 买卖股票的最佳时机4 {
    public static void main(String[] args) {
        买卖股票的最佳时机4 s = new 买卖股票的最佳时机4();
        System.out.println(s.maxProfit(3, new int[]{1, 2, 3, 8, 1, 9, 3, 6}));
    }

    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[][][] pd = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j  = k; j > 0; j--) {
                if (i == 0) {
                    pd[i][j][0] = 0;
                    pd[i][j][1] = -prices[i];
                    continue;
                }
                pd[i][j][0] = Math.max(pd[i - 1][j][0], pd[i - 1][j][1] + prices[i]);
                pd[i][j][1] = Math.max(pd[i - 1][j][1], pd[i - 1][j - 1][0] - prices[i]);
            }
        }
        return pd[prices.length - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int[][] pd = new int[prices.length][2];
        if (prices.length <= 1) {
            return 0;
        }
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                pd[i][0] = 0;
                pd[i][1] = -prices[i];
                continue;
            }
            pd[i][1] = Math.max(pd[i - 1][1], pd[i - 1][0] - prices[i]);
            pd[i][0] = Math.max(pd[i - 1][0], pd[i - 1][1] + prices[i]);
        }
        return pd[prices.length - 1][0];
    }
}

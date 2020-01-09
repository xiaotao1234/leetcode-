package 动态规划或贪心;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        买卖股票的最佳时机2 s = new 买卖股票的最佳时机2();
        System.out.println(s.maxProfit(new int[]{1, 2, 1, 4, 8, 9}));
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

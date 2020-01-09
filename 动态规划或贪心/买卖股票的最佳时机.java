package 动态规划或贪心;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//
//注意你不能在买入股票前卖出股票。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        买卖股票的最佳时机 s = new 买卖股票的最佳时机();
        System.out.println(s.maxProfit(new int[]{2,1,4}));
    }

    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int pd[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                pd[i][1] = -prices[i];
                pd[i][0] = 0;
                continue;
            }
            pd[i][1] = Math.max(pd[i - 1][1], - prices[i]);
            pd[i][0] = Math.max(pd[i - 1][0], pd[i-1][1]+prices[i]);
        }
        return pd[prices.length-1][0];
    }
}

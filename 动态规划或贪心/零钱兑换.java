package 动态规划或贪心;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//示例 1:
//
//输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//示例 2:
//
//输入: coins = [2], amount = 3
//输出: -1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/coin-change
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 零钱兑换 {
    public static void main(String[] args) {
        零钱兑换 s = new 零钱兑换();
        System.out.println(s.coinChange(new int[]{1, 2, 8}, 100));
    }

    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int s : coins) {
                if (j - s >= 0 && dp[j - s] != amount) {
                    dp[j] = Math.min(dp[j], dp[j - s] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else
            return dp[amount];
    }
}

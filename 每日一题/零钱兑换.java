package 每日一题;

import java.util.Arrays;

/**
 * Created by Xiao Tao on 2020/3/8 9:06
 */
public class 零钱兑换 {

    public static void main(String[] args) {
        零钱兑换 s1 = new 零钱兑换();
        System.out.println(s1.coinChange1(new int[]{1}, 1));
    }

    public int coinChange(int[] coins, int amount) {//每次从当期向后进行扩展来dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i == 0) {
                    if (coins[j] <= amount) {
                        dp[coins[j]] = 1;
                    }
                } else {
                    if (i + coins[j] <= amount) {//问题主要会出现在这里，因为是向后进行扩展的，
                        // 所以这里要计算出当前加向后扩展值，来判断扩展后是否超出了要求的总额，超过则为无效数额，
                        // 但是当我们当前的数额或其与单个硬币金额相加超过了Inter.MAX_VALUE时，就会出错。
                        dp[i + coins[j]] = Math.min(dp[i] + 1, dp[i + coins[j]]);
                    }
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE && dp[amount] < amount + 1) {
            return dp[amount];
        } else {
            return -1;
        }
    }

    public int coinChange1(int[] coins, int amount) {//很好的符合了dp的思想，即当前的值依靠一个关联条件，
        // 来利用前面已经计算出的值来推出当前值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}

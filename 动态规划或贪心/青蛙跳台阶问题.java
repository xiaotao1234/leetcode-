package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/28 16:09
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class 青蛙跳台阶问题 {

    public static void main(String[] args) {
        青蛙跳台阶问题 s = new 青蛙跳台阶问题();
        System.out.println(s.numWays(46));
    }

    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
        }
        return dp[n];
    }

}

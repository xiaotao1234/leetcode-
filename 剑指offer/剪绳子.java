package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/14 10:18
 */
public class 剪绳子 {
    public static void main(String[] args) {
        剪绳子 s = new 剪绳子();
        System.out.println(s.cuttingRope2(10));
    }

    public int cuttingRope(int n) {//完全背包问题的变形
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(i * dp[j - i], dp[j]);
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];//dp[i]为长度为i的绳子的最大值。
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(i * dp[j - i], dp[j]);
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {//错误的规划
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {//错误点在于无法由前推到后，如在i为1时，j无取值
            //i++到2，j取值只有1，dp[2] = Math.max(1*dp[2-1],dp[2])
            //dp[1]未赋值，其为初始值0
            //则dp[2]也为0，所以后面的所有取值也都为0
            //关键问题是在2的最大的数为1，即1*1
            //但是当这个用在4上来求最大值时，就会出现错误，因为4的最大值明显是4，即2*2，但是用2来求的话就是1*1为1，
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }
        return dp[n];
    }
}

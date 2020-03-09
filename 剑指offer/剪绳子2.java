package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/18 8:39
 */
public class 剪绳子2 {
    public static void main(String[] args) {
        剪绳子2 s = new 剪绳子2();
        System.out.println(s);
    }

    public int cuttingRope(int n) {//完全背包问题的变形
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[i] * (j - i));

                dp[j] = Math.max(dp[j], dp[j-i] * i);
            }
        }
        return dp[n];
    }
}

package 练习;

/**
 * Created by Xiao Tao on 2020/1/15 14:15
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        爬楼梯 s1 = new 爬楼梯();
        System.out.println(s1.climbStairs(3 ));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/9 22:07
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        爬楼梯 s1 = new 爬楼梯();
        System.out.println(s1.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i==1){
                dp[1] = 1;
            }else if(i==2){
                dp[2] = 2;
            }else if(i>2){
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}

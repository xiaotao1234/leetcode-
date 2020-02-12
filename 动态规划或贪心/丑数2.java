package 动态规划或贪心;

public class 丑数2 {
    public static void main(String[] args) {
        丑数2 s = new 丑数2();
        System.out.println(s.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int o = 0;
        int p = 0;
        int q = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[o]*2, Math.min(dp[p]*3, dp[q]*5));
            if(dp[o]*2==dp[i]){
                o++;//当前yu
            }
            if(dp[p]*3==dp[i]){
                p++;
            }
            if(dp[q]*5==dp[i]){
                q++;
            }
        }
        return dp[n-1];
    }
}

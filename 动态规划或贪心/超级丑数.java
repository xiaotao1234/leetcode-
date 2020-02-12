package 动态规划或贪心;

public class 超级丑数 {
    public static void main(String[] args) {
        超级丑数 s = new 超级丑数();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {//每个添加的数都是前面的数乘 primes得到的
        //每次取数是primes中的每个数字和其每个数字对应的dp数组下标的乘积的最小值，且当primes中的这个数和前面的一个数相乘后
        //这个数字对应的dp数组下标应该加1，即其下一次应该从数组的下一个开始取
        int[] s = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                int m = dp[s[j]] * primes[j];
                if (dp[i] > m) {
                    dp[i] = m;
                }
            }
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * (dp[s[j]]) == dp[i]) {
                    s[j] = s[j] + 1;
                }
            }
        }
        return dp[n - 1];
    }
}

package 动态规划或贪心;

import 树.迭代法的树的后序遍历;

/**
 * Created by Xiao Tao on 2020/2/9 22:01
 */
public class 猜数字大小2 {

    public static void main(String[] args) {
        猜数字大小2 s = new 猜数字大小2();
        System.out.println(s.getMoneyAmount(2));
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                for (int l = j; j < i; j++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][l - 1] + l + dp[l + 1][i]);
                }
            }
        }
        return dp[n][n];
    }

    public int getMoneyAmountdp(int n) {//dp解法
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmountdp1(int n) {  //dp优化解法，即根据发现---取后半段的数作为第一次尝试总比取前半段大，因为要找的是最大值，所以直接在后半段选取就可以了，减少了取的范围
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start + (len - 1) / 2; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/cai-shu-zi-da-xiao-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

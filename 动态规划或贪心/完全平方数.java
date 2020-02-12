package 动态规划或贪心;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//示例 1:
//
//输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//示例 2:
//
//输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/perfect-squares
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 完全平方数 {
    public static void main(String[] args) {
        完全平方数 s = new 完全平方数();
        System.out.println(s);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;//子大小范围的最坏情况为每次加一
            for (int j = 1; i - j * j >= 0; j++) {//根据子范围的大小，对子范围的可能存在的解进行遍历（j就是0，i的子集），对子范围进行求解，即子范围大小在可以满足其条件的子集中求解找出子范围的最小值，
                //和零钞拼大钞的问题类似
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

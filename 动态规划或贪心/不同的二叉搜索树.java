package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/13 8:20
 */
public class 不同的二叉搜索树 {

    public static void main(String[] args) {
        不同的二叉搜索树 s = new 不同的二叉搜索树();
        System.out.println(s.numTrees(3));
    }

    public int numTrees(int n) {//这里的关键是要意识到因为只求数目，不求具体有哪些，因此1..4能组成的二叉搜索树的种类和3...6能组成的二叉搜索树的种类的数量是一样的，因此可以只使用一纬dp来建立状态转移方程。
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1] + dp[i - j];
            }
        }
        return dp[n];
    }
}

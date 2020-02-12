package 动态规划或贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/10 13:23
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class PerfectSquares完美方块 {
    public static void main(String[] args) {
        PerfectSquares完美方块 s = new PerfectSquares完美方块();
        System.out.println(s.numSquares(11));
    }

    public int numSquares(int n) {  //解法正确但是时间复杂度过高，对其时间复杂度进行估算为（N平方），
        List<Integer> list = new ArrayList<>();
        int item = 1;
        while (item*item<=n) {
            list.add(item*item);
            item++;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (list.contains(i)) {
                dp[i] = 1;
            }else {
                for (int j = 1; j < i; j++) {//这个解法时间复杂度高的原因主要也是在这里，因为这里对子集的求解进行了无差别的遍历，然后进行筛选，进行了过多的遍历，没有充分的挖掘题目条件
                    if (dp[j] != Integer.MIN_VALUE && list.contains(i - j)) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {//这个解法高效的关键所在，对于每个子解，我们需要遍历的只是子解的可用的情况，通过遍历平方根对比前面遍历平方数次数要减少一个次方，效率因此也高的多，时间复杂度为(Nlg n)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

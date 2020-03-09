package 动态规划或贪心;

import java.util.Map;

/**
 * Created by Xiao Tao on 2020/1/15 14:47
 * 问题1：如果 word1[0..i-1] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要几步呢？
 *
 * 答：先使用 k 步，把 word1[0..i-1] 变换到 word2[0..j-1]，消耗 k 步。再把 word1[i] 改成 word2[j]，就行了。
 * 如果 word1[i] == word2[j]，什么也不用做，一共消耗 k 步，否则需要修改，一共消耗 k + 1 步。
 *
 * 问题2：如果 word1[0..i-1] 到 word2[0..j] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
 *
 * 答：先经过 k 步，把 word1[0..i-1] 变换到 word2[0..j]，消耗掉 k 步，再把 word1[i] 删除，
 * 这样，word1[0..i] 就完全变成了 word2[0..j] 了。一共 k + 1 步。
 *
 * 问题3：如果 word1[0..i] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
 *
 * 答：先经过 k 步，把 word1[0..i] 变换成 word2[0..j-1]，消耗掉 k 步，接下来，再插入一个字符 word2[j], word1[0..i] 就完全变成了
 * word2[0..j] 了。
 *
 * 从上面三个问题来看，word1[0..i] 变换成 word2[0..j] 主要有三种手段，用哪个消耗少，就用哪个。
 */
public class 编辑距离 {
    public static void main(String[] args) {
        编辑距离 s = new 编辑距离();
        System.out.println(s);
    }

    int[][] dp;

    public int minDistance1(String word1, String word2) {
        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }
        dp = new int[word1.length() + 1][word2.length() + 1];//dp[i][j]表示到word1的i位置转化为word2的j位置最小需要几步操作
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    //dp[i-1][j]为删除操作，即因为dp[i-1][j],两个字符串相等了，现在要dp[i][j]相等，那么删除word1的第i个元素，word1[i]变为了word[i-1],其和word2[j]依然相等，以下同理
                    //dp[i][j-1]为插入操作，
                    //dp[i-1][j-1]为替换操作
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

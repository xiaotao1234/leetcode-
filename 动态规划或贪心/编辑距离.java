package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/1/15 14:47
 */
public class 编辑距离 {
    public static void main(String[] args) {
        编辑距离 s = new 编辑距离();
        System.out.println(s);
    }

    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];//dp[i][j]表示到word1的i位置转化为word2的j位置最小需要几步操作
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    //dp[i-1][j]为删除操作，即因为dp[i-1][j],两个字符串相等了，现在要dp[i][j]相等，那么删除word1的第i个元素，word1[i]变为了word[i-1],其和word2[j]依然相等，以下同理
                    //dp[i][j-1]为插入操作，
                    //dp[i-1][j-1]为替换操作
                }
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}

package 练习;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/9 23:02
 */
public class 单词拆分 {

    public static void main(String[] args) {
        单词拆分 s1 = new 单词拆分();
        List<String> s = new ArrayList<>();
        s.add("leet");
        s.add("code");
        System.out.println(s1.wordBreak("leetcode", s));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    if (wordDict.contains(s.substring(j, i))) {
                        dp[i - 1] = true;
                    }
                } else {
                    if (wordDict.contains(s.substring(j, i)) && dp[j-1] == true) {
                        dp[i - 1] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}

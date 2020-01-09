package 动态规划或贪心;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//说明：
//
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-break
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 单词拆分 {
    public static void main(String[] args) {
        单词拆分 s = new 单词拆分();
        System.out.println(s);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> stringSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]&&stringSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

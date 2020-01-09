package 动态规划或贪心;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//
//说明：
//
//分隔时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-break-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 单词拆分2 {
    public static void main(String[] args) {
        单词拆分2 s = new 单词拆分2();
        System.out.println(s);
    }

    public List<String> wordBreak(String s, Set<String> wordDict) { //普通回溯算法，无记忆优化
        return word_Break(s, wordDict, 0);
    }

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }


    public List<String> wordBreak1(String s, Set<String> wordDict) {// 记忆化回溯
        return word_Break1(s, wordDict, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break1(String s, Set<String> wordDict, int start) {
        //关键点是使用了map来记录已经求出了的start到s.length子串的所有可能的list
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public List<String> wordBreak2(String s, Set<String> wordDict) {//动态规划版写法
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }

}

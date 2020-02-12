package 练习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xiao Tao on 2020/2/10 8:12
 */
public class 单词拆分2 {
    public static void main(String[] args) {
        单词拆分 s1 = new 单词拆分();
        System.out.println(s1);
    }

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length()];
//        Map<Integer, List<String>> map = new HashMap<>();
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (j == 0) {
//                    if (wordDict.contains(s.substring(j, i))) {
//                        dp[i - 1] = true;
//                        if (map.get(i - 1) != null && map.get(i - 1).size() != 0) {
//                            map.get(i - 1).add(s.substring(j, i));
//                        }else {
//                            List<String> list = new ArrayList<>();
//                            list.add();
//                            map.put(i-1,list.);
//                        }
//                    }
//                } else {
//                    dp[i - 1] = wordDict.contains(s.substring(j, i)) && dp[j - 1];
//                }
//            }
//        }
//    }
}

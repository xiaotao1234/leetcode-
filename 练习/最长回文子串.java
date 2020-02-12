package 练习;

/**
 * Created by Xiao Tao on 2020/1/14 20:00
 */
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class 最长回文子串 {
    public static void main(String[] args) {
        最长回文子串 s1 = new 最长回文子串();
        System.out.println(s1.longestPalindrome("s"));
    }

    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = ((i - j < 3) || (dp[j + 1][i - 1])) && (s.charAt(i) == s.charAt(j));
                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    s1 = s.substring(j, i+1);
                }
            }
        }
        return s1;
    }
}

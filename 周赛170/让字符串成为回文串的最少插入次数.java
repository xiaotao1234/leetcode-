package 周赛170;

//https://leetcode-cn.com/contest/weekly-contest-170/problems/minimum-insertion-steps-to-make-a-string-palindrome/
//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
//
//请你返回让 s 成为回文串的 最少操作次数 。
//
//「回文串」是正读和反读都相同的字符串。
public class 让字符串成为回文串的最少插入次数 {
    public static void main(String[] args) {
        让字符串成为回文串的最少插入次数 s = new 让字符串成为回文串的最少插入次数();
        System.out.println(s.minInsertions("abc"));
    }

    public int minInsertions(String s) {
        int a = 0;
        if (isdz(s)) {
            return 0;
        }
        for(int i=0;i<s.length()-1;){
            if(s.charAt(i)==s.charAt(s.length()-1-i)){
                i++;
            }else {
                s = s+s.charAt(i);
                a++;
                i++;
            }
        }
        return a;
    }

    public boolean isdz(String s) {
        int length = s.length();
//        if(length%2==0){
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
//        }else {
//
//        }
        return true;
    }
}

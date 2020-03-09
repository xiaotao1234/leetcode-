package 递归练习;

import java.util.Arrays;

/**
 * Created by Xiao Tao on 2020/2/21 13:26
 */
public class 第k个语法符号 {
    public static void main(String[] args) {
        第k个语法符号 s1 = new 第k个语法符号();
        System.out.println(s1.myPow(1, 1));
    }

    String tem = "0";

    public int myPow(int N, int K) {
        if (N == 0) {
            return Integer.valueOf(String.valueOf(tem.charAt(K - 1)));
        }
        String tem1 = "";
        for (int i = 0; i < tem.length(); i++) {
            if (tem.charAt(i) == '0') {
                tem1 = tem1 + "01";
            } else {
                tem1 = tem1 + "10";
            }
        }
        tem = tem1;
        return myPow(N - 1, K);
    }

    public int kthGrammar(int N, int K) {
        char[] chars = dp(N);
        return Integer.valueOf(String.valueOf(chars[K-1]));
    }

    public char[] dp(int N) {
        if (N == 1) {
            char[] chars = new char[1];
            chars[0] = '0';
            return chars;
        }
        char[] chars = dp(N - 1);
        char[] chars1 = new char[chars.length * 2];
        for (int i = 0; i < chars1.length; i++) {
            if (i < chars.length) {
                chars1[i] = chars[i];
            } else {
                chars1[i] = (char) (chars[i-chars.length] == 1 ? 0 : 1);
            }
        }
        return chars1;
    }

    public int kthGrammar1(int N, int K) {
        if (N == 1) return 0;
        if (K <= 1 << N-2)
            return kthGrammar1(N-1, K);
        return kthGrammar1(N-1, K - (1 << N-2)) ^ 1;
    }
}











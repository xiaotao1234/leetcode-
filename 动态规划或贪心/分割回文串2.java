package 动态规划或贪心;

public class 分割回文串2 {
    public static void main(String[] args) {
        分割回文串2 s = new 分割回文串2();
        System.out.println(s.minCut("abcdef"));
    }

    int leastnum = Integer.MIN_VALUE;

    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        isplidrom(s, dp);
        dpRec(0, 0, s, dp);
        return leastnum;
    }

    public void dpRec(int start, int c, String s, boolean[][] dp) {
        if (leastnum < 0 && start == s.length()) {
            leastnum = c;
            return;
        }
        if (leastnum > 0 && c > leastnum) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                c = c+1;
                dpRec(i+1, c, s, dp);
                c = c-1;
            }
        }
    }

    public void isplidrom(String s, boolean[][] dp) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (i - j < 3 || dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = true;
                }
            }
        }
    }
}

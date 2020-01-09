package 动态规划或贪心;

public class 一和零 {
    public static void main(String[] args) {
        一和零 s = new 一和零();
        System.out.println(s.findMaxForm(new String[]{"101", "111", "10", "00"}, 5, 3));
    }

//    public int findMaxForm(String[] strs, int m, int n) {//m->0,n->1
//        if (strs.length == 0 || (m == 0 & n == 0)) {
//            return 0;
//        }
//        int[][][][] dp = new int[strs.length][m][n][2];
//        for (int i = 0; i < strs.length; i++) {
//            int zero = get0(strs[i]);
//            int one = get1(strs[i]);
//            if (i == 0) {
//                if (m >= zero && n >= one){
//                    dp[i][m-zero][n-one][0] = 1;
//                }
//                dp[i][m][n][1] = 0;
//                continue;
//            }
//            if (m >= zero && n >= one){
//                dp[i][m-zero][n-one][0] = Math.max(dp[i-1][m-zero][n-one][0],);
//            }
//        }
//    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (m == 0 && n == 0 || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] l = get0(s, "0");
            for (int i = m; i >= l[0]; i--) {
                for (int j = n; j >= l[1]; j--) {
                    dp[i][j] = Math.max(dp[i - l[0]][j - l[1]] + 1, dp[i][j]);
//                    if(dp[i][j]>1){
                        System.out.println(dp[i][j]);
                        System.out.println("i"+i+"/"+"j"+j+"     "+"i'"+(i-l[0])+" "+"j"+(j-l[1]));
                        System.out.println("\n");
//                    }
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        if (m == 0 && n == 0 || strs.length == 0) {
            return 0;
        }
        int length = strs.length;
        int[][] dp = new int[m][n];
        for (String s : strs) {
            int[] l = get0(s, "0");
            for (int i = m; i > l[0]; i--) {
                for (int j = n; j > l[1]; j--) {
                    dp[i][j] = Math.max(dp[i - l[0]][j - l[1]] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] get0(String s, String target) {
        int[] l = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(target))
                l[0]++;
            else
                l[1]++;
        }
        return l;
    }
}

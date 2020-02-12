package 练习;

/**
 * Created by Xiao Tao on 2020/1/17 15:07
 */
public class 最大正方形 {
    public static void main(String[] args) {
        最大正方形 s1 = new 最大正方形();
        System.out.println(s1.maximalSquare(new char[][]{{'0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else {
                        dp[i][j] = 1;
                        max = Math.max(dp[i][j], max);
                    }
                    continue;
                }
                if(matrix[i][j] != '0'){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

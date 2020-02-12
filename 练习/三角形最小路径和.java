package 练习;

import java.util.List;

/**
 * Created by Xiao Tao on 2020/1/17 16:05
 */
public class 三角形最小路径和 {
    public static void main(String[] args) {
        三角形最小路径和 s1 = new 三角形最小路径和();
        System.out.println(s1);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(0).size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    continue;
                }
                if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])+triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size() - 1; i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }
        return min;
    }
}

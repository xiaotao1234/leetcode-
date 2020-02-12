package 周赛171;

import java.util.Arrays;

public class Solution {
    public int minimumDistance(String word) {
        int len = word.length();
        char[] chars = word.toCharArray();  // 调用 charAt 方法并不是痛点，所以此处转换为 char 数组意义不大

        int[][] d = new int[len][len];      // DP Array
        int[][] dist = new int[len][len];   // dist Array，用 tabular 空间换时间避免重复计算，
        // 但此步意义也不明显，因为重复计算并不频繁，可省略
        for (int i = 0; i < len; i++)
            for (int j = i+1; j < len; j++)
                dist[i][j] = distance(chars[i]-'A', chars[j]-'A');

        for (int i = 1; i < len; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);   // 初始化

            for (int j = 0; j < i-1; j++) {
                // 将原先放在第 i-1 个字母上的手指移到 i 上，此时两根手指分别以第 i, j-1 个字母为终点
                d[i][j] = Math.min(d[i][j], d[i-1][j] + dist[i-1][i]);
                // 将原先放在第 j 个字母上的手指移到 i 上，此时两根手指分别以第 i, i-1 个字母为终点
                d[i][i-1] = Math.min(d[i][i-1], d[i-1][j] + dist[j][i]);
            }

            // 如果此前仅使用了一根手指，可以将第二根手指放在第 i 个字母上，不消耗步数；可以将消耗理解为 `d[i-1][i-1] + 0`
            d[i][i-1] = Math.min(d[i][i-1], d[i-1][i-1]);
            // 依旧仅使用一根手指
            d[i][i] = d[i-1][i-1] + dist[i-1][i];
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len-1; i++)
            ret = Math.min(ret, d[len-1][i]);   // 无需考虑 d[len-1][len-1]，必然不是最优

        return ret;
    }

    private int distance(int a, int b) {
        int x1 = a / 6, y1 = a - 6*x1;
        int x2 = b / 6, y2 = b - 6*x2;

        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}

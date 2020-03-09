package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/8 23:20
 */
public class 马在棋盘上的概率 {
    public double knightProbability(int N, int K, int r, int c) {
        get(N, K, r, c, 1);
        return 1 - all;
    }

    double all = 0;
    int[][] ints = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public void get(int N, int K, int r, int c, double addvalue) {
        if (K == 0) {
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (r - ints[i][0] < 0 || c - ints[i][1] < 0 || r - ints[i][0] >= N || c - ints[i][1] >= N) {
                all = all + addvalue / 8;
            } else {
                get(N, K - 1, r - ints[i][0], c - ints[i][1], addvalue / 8);
            }
        }
    }
}

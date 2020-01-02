//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//问总共有多少条不同的路径？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/unique-paths
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 不同路径 {
    public static void main(String[] args) {
        不同路径 s = new 不同路径();
        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(s.uniquePaths(1,2));
    }

    public int uniquePaths(int m, int n) {
        int P[][] = new int[m][n];
        if (m == 0 || n == 0) {
            return 1;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == 0 || j == 0) {
                    P[i][j] = 0;
                } else {
                    P[i][j] = P[i - 1][j] + P[i][j - 1];
                }
            }
        }
        return P[m - 1][n - 1];
    }
}

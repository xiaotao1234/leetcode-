
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//示例:
//
//输入:
//[
//  ['1','0','1','0','0'],
//  ['1','0','1','1','1'],
//  ['1','1','1','1','1'],
//  ['1','0','0','1','0']
//]
//输出: 6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximal-rectangle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 最大矩形 {
    public static void main(String[] args) {
        最大矩形 s = new 最大矩形();
        char[][] c = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(s.maximalRectangle(c));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][][] dps = new int[height][width][height];
        int[][] dd = new int[height][width];
        for (int i = 0; i < height; i++) {
            int m = 0;
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') {
                    m = 0;
                } else {
                    m++;
                }
                dd[i][j] = m;
            }
        }
        int max = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                for (int kl = 0; kl <= j; kl++) {
                    int a = j - kl + 1;
                    int b = getmin(dd, i, j, kl);
                    max = Math.max(max, a * b);
                }
            }
        }
        return max;
    }


    public int getmin(int[][] matrix, int i, int j, int k) {
        int min = Integer.MAX_VALUE;
        for (int l = k; l <= j; l++) {
            min = Math.min(min, matrix[l][i]);
        }
        return min;
    }
}

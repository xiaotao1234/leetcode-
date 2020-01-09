package 动态规划或贪心;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//https://leetcode-cn.com/problems/maximal-square/
public class 最大正方形 {
    public static void main(String[] args) {
        最大正方形 s = new 最大正方形();
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int height = matrix.length;
        int length = matrix[0].length;
            int max = 0;
        int[][] ma = new int[height][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0 || i == 0) {
                    if (String.valueOf(matrix[j][i]).equals("0")) {
                        ma[j][i] = 0;
                    } else {
                        ma[j][i] = 1;
                    }
                } else {
                    if (String.valueOf(matrix[j][i]).equals("0")) {
                        ma[j][i] = 0;
                    } else {
                        ma[j][i] = Math.max(ma[j - 1][i - 1], Math.max(ma[j - 1][i], ma[j][i - 1])) + 1;
                    }
                }
                if (ma[j][i] > max) {
                    max = ma[j][i];
                }
            }
        }
        return max;
    }
}

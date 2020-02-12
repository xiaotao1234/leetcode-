package 练习;

/**
 * Created by Xiao Tao on 2020/1/14 21:23
 */
public class 最大矩形 {
    public static void main(String[] args) {
        最大矩形 s1 = new 最大矩形();
        System.out.println(s1);
    }
    int[][] dp;
    public int maximalRectangle(char[][] matrix) {
        getMin(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<i;j++){
                
            }
        }
        return 1;
    }

    public void getMin(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int m = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]==1){
                    m = m+1;
                }else {
                    m = 0;
                }
                dp[i][j] = m;
            }
        }
    }
}

package 树;

/**
 * Created by Xiao Tao on 2020/2/23 21:45
 */
public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        不同的二叉搜索树 s = new 不同的二叉搜索树();
        System.out.println(s.numTrees(4));
    }

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] tem = new int[n + 1];
        tem[0] = 1;
        tem[1] = 1;
        tem[2] = 2;
        for (int i = 1; i <= n; i++) {
            int all = 0;
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    all = all + tem[i - j];
                } else if (i == j) {
                    all = all + tem[j - 1];
                } else {
                    all = all + (tem[j - 1] * tem[i - j]);
                }
            }
            tem[i] = all;
        }
        return tem[n];
    }
}

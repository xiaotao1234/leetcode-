package 递归练习;

/**
 * Created by Xiao Tao on 2020/3/9 13:36
 */
public class x的n次幂函数 {
    public double myPow(double x, int n) {
        if (n > 0) {
            return dp(x, n);
        } else {
            return 1 / dp(x, -n);
        }
    }

    public double dp(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = n / 2;
        double l = dp(x, n / 2);
        if (half * 2 == n) {
            return l * l;
        } else {
            return l * l * x;
        }
    }
}

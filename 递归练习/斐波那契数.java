package 递归练习;

import java.util.Arrays;

/**
 * Created by Xiao Tao on 2020/3/9 11:37
 */
public class 斐波那契数 {
    public int fib(int N) {
        d = new int[N + 1];
        Arrays.fill(d, -1);
        return dp(N);
    }

    int[] d;

    public int dp(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            if (d[i] >= 0) {
                return d[i];
            }
            return dp(i - 1) + dp(i - 2);
        }
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/1 22:42
 */
public class 只有两个键的键盘 {
    public int minSteps(int n) {
        int d = 2;
        int ans = 0;
        while (n > 1) {
            if (n % d == 0) {
                ans = ans + d;
                n = n / d;
            }
            d++;
        }
        return ans;
    }
}

package 周赛172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/1/19 11:39
 */
public class 灌溉花园的最少水龙头数目 {

    public static void main(String[] args) {
        灌溉花园的最少水龙头数目 s = new 灌溉花园的最少水龙头数目();
        System.out.println(s);
    }

    public int minTaps1(int n, int[] ranges) {
        int[] dp = new int[ranges.length];//dp[i]表示第i个水龙头能有意义的打开的前置水龙头数+1，有意义的意思即其前置被所有的区域被浇灌，且其浇灌区域有其单独浇灌区域，非重。若其不能构成相关的区域则其为-1。
        Arrays.fill(dp, -1);
        for (int i = 0; i < ranges.length; i++) {
            if (i < 2) {
                dp[0] = 1;
                if (dp[1] >= 1) {
                    dp[1] = 1;
                }
            } else
                for (int j = 1; j <= i - 1; j++) {
                    if (dp[i - j] != -1 && ranges[i] + j > ranges[i - j] && ranges[i - j] > 0) {
                        if (dp[i] == -1) {
                            dp[i] = dp[i - j] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - j] + 1);
                        }
                    }
                }
        }
        return dp[ranges.length - 1];
    }

    public int minTaps(int n, int[] ranges) {
        int[] list = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);
            for (int j = l; j < r; j++) {
                list[j] = Math.max(list[j],r);
            }
        }
        return 0;
    }
}

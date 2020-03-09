package 周赛179;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/8 10:50
 */
public class 通知所有员工所需的时间 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        int current = headID;
        int[] dp = new int[manager.length];
        int i = 0;
        int all = 0;
        while (all <= 7) {
            for (int l : manager) {
                if (l == current) {
                    dp[i] = dp[current] + manager[current];
                }
                i++;
            }

        }
        return max;
    }
}

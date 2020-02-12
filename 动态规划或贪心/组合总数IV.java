package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/11 15:20
 */
public class 组合总数IV {
    public static void main(String[] args) {
        组合总数IV s = new 组合总数IV();
        System.out.println(s.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target];
        for (int a : nums) {
            if (a < target) {
                dp[a - 1] = 1;
            }
        }
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                for (int a : nums) {
                    if (i - a == j) {
                        dp[i] = dp[i] + dp[j];
                    }
                }
            }
        }
        return dp[target - 1];
    }
}

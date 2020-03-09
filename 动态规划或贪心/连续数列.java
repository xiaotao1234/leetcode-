package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/6 23:40
 */
public class 连续数列 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[0] = nums[0];
                max = dp[0];
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

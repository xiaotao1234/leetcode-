package 练习;

/**
 * Created by Xiao Tao on 2020/1/17 15:27
 */
public class 最大子序和 {
    public static void main(String[] args) {
        最大子序和 s1 = new 最大子序和();
        System.out.println(s1.maxSubArray(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
                if (i==0){
                    dp[i] = nums[i];
                    max = Math.max(max,dp[i]);
                    continue;
                }
                dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
                max = Math.max(max, dp[i]);
        }
        return max;
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/28 22:43
 */
public class 连续的子数组和 {
    public static void main(String[] args) {
        连续的子数组和 s = new 连续的子数组和();
        System.out.println(s.checkSubarraySum(new int[]{0, 1, 0}, 0));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
//        int[][] dp = new int[nums.length][nums.length];
        int m,n;
        for (int i = 0; i < nums.length; i++) {
//            dp[i][i] = nums[i];
            m = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                n = m + nums[j];
                if (k == 0) {
                    if (n == 0) {
                        return true;
                    }
                } else {
                    if (n % k == 0) {
                        return true;
                    }
                }
                m = n;
            }
        }
        return false;
    }
}

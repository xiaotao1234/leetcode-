package 数组;

/**
 * Created by Xiao Tao on 2020/3/5 11:20
 */
public class 乘积小于K的子数组 {

    public static void main(String[] args) {
        乘积小于K的子数组 s1 = new 乘积小于K的子数组();
        System.out.println(s1.numSubarrayProductLessThanK1(new int[]{10,5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int all = 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == 0) {
                    dp[j] = nums[0];
                    if (dp[j] < k) {
                        all = all + 1;
                    }
                } else {
                    if (dp[j] < k) {
                        dp[j] = (i > j ? (dp[j] * nums[i]) : nums[i]);
                        if (dp[j] < k) {
                            all = all + 1;
                        } else {
                            dp[j] = k;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return all;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {//双指针解法
        int all = 0;
        int left = 0;
        int right = 0;
        int tmp = 1;
        while (right < nums.length) {
            tmp = tmp * nums[right];
            while (tmp >= k) {
                tmp = tmp / nums[left];
                left++;
            }
            all = all + right - left + 1;
            right++;
        }
        return all;
    }
}

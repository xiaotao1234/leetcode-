package 动态规划或贪心;

public class 打家劫舍 {
    public static void main(String[] args) {
        打家劫舍 s = new 打家劫舍();
        System.out.println(s.rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp[i] = nums[0];
                continue;
            }
            if(i==1){
                dp[i] = Math.max(nums[0],nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[length-1];
    }
}

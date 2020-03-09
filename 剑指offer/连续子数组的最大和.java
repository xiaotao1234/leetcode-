package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/18 10:12
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        连续子数组的最大和 s = new 连续子数组的最大和();
        System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            if(now>0){
                now = now+nums[i];
            }else {
                now = nums[i];
            }
            if(now>max){
                max = now;
            }
        }
        return max;
    }
}

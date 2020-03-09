package 数组;

/**
 * Created by Xiao Tao on 2020/3/5 22:22
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s
 * 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        长度最小的子数组 s1 = new 长度最小的子数组();
        System.out.println(s1.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int all = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            all = all + nums[right];
            while (all >= s) {
                min = Math.min(min, right - left + 1);
                all = all - nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

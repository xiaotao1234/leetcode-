package 双指针;

import java.util.Arrays;

/**
 * Created by Xiao Tao on 2020/3/6 0:05
 */
public class 两数之和 {
    public static void main(String[] args) {
        两数之和 s1 = new 两数之和();
        System.out.println(s1.twoSum(new int[]{3,2,4}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] m = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        while (right < nums.length - 1 && left > 0) {
            if (nums[left] + nums[right] < target)
                right++;
            else if (nums[left] + nums[right] > target)
                left--;
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i] == left) {
                left = i;
            }
            if (m[i] == right) {
                right = i;
            }
        }
        return new int[]{left, right};
    }
}

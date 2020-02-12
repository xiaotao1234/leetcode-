package 数组;

import 练习.买卖股票的最佳时机;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/7 9:18
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 三数之和 {
    public static void main(String[] args) {
        三数之和 s1 = new 三数之和();
        System.out.println(s1.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= 0 && i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < i && right > i) {
                if (nums[left] + nums[i] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                } else if (nums[left] + nums[i] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            while (nums[i] > 0 && i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 三数之和 {
    public static void main(String[] args) {
        三数之和 s = new 三数之和();
        System.out.println(s.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {//首先我们先抓几个要点
        //1.满足条件a+b+c=0
        //2.不重复
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {//满足条件和为0
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;//去重，即在加入当前元素为最小数的所有组合后，循环对其后面的元素进行判断直到跳过所有的元素值相同的节点，避免了得到重复解
                    while (left < right && nums[right] == nums[right - 1])
                        right--;//同上
                    left++;
                    right--;//将左右标都进行转移
                } else if (sum <= 0) {
                    left++;//三数和小于0，为了增大和到0，所以要将左标右移
                } else {
                    right--;//同上
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }
}

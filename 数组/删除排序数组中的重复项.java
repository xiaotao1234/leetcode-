package 数组;

/**
 * Created by Xiao Tao on 2020/3/4 23:09
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        删除排序数组中的重复项 s1 = new 删除排序数组中的重复项();
        System.out.println(s1.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;//当前的有效数的右边界
        while (i < nums.length) {
            while (i < nums.length && nums[j] == nums[i]) {
                i++;
            }
            if (i != nums.length) {
                j = j + 1;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}

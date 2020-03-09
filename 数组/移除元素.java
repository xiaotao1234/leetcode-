package 数组;

/**
 * Created by Xiao Tao on 2020/3/4 21:59
 */
public class 移除元素 {

    public static void main(String[] args) {
        移除元素 s1 = new 移除元素();
        System.out.println(s1.removeElement(new int[]{3, 3}, 5));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && nums[i] != val) {
                i++;
            }
            while (j > -1 && nums[j] == val) {
                j--;
            }
            if (j > 0 && i < nums.length && nums[i] == val && nums[j] != val && i < j) {
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                j--;
            }
        }
        int l = 0;
        while (l < nums.length && nums[l] != val) {
            l++;
        }
        return l;
    }
}

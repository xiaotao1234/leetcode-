package 双指针;

/**
 * Created by Xiao Tao on 2020/3/9 21:29
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {//我的解法
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            l = i + 1;
            boolean find = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == l && find == false) {
                    find = true;
                } else if (nums[j] == l && find == true) {
                    return l;
                }
            }
        }
        return l;
    }

    public int findDuplicate1(int[] nums) {//二分查找解法
        int left = 0;
        int right = nums.length - 1;
        int mi = (nums.length - 1) / 2;
        while (true) {
            int a = 0;
            for (int i = left; i < right; i++) {
                if(nums[i]<mi){
                    a++;
                }
            }
            if()
        }
    }
}

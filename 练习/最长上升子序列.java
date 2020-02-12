package 练习;
/**
 * Created by Xiao Tao on 2020/2/6 15:19
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        最长上升子序列 s1 = new 最长上升子序列();
        System.out.println(s1);
    }

    public int lengthOfLIS(int[] nums) {//经典动态规划解法
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {//第一个循环是将大问题分割成多个子集，
            for (int j = 0; j < i; j++) {//对子集逐步求解
                if (nums[i] > nums[j]) {//当前数字只要大于任何一个序号比他小的数，那他就有成为那个数字代表的最大序列的下一个数字的资格
                    dp[i] = Math.max(dp[i], dp[j] + 1);//选择当前数字有资格成为下一个数字的最长的子序列来作为当前数的序列。
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) { //二分来进行区间查找，核心是当当前数大于上一个数字时，直接加入到上升序列，当前数小于上一个数字时，
        // 找出其在所有的上升序列中的位置，并对其进行替换，（只替换，但不移除元素），待且用于后续的区间查找，
        int len = nums.length;
        // 特判
        if (len <= 1) {
            return len;
        }
        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引

        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            // 这里，因为当前遍历的数，有可能比有序数组 tail 数组实际有效的末尾的那个元素还大
            // 【逻辑 1】因此 end + 1 应该落在候选区间里
            int right = end + 1;
            while (left < right) {
                // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                // int mid = left + (right - left) / 2;
                int mid = (left + right) >>> 1;

                if (tail[mid] < nums[i]) {
                    // 中位数肯定不是要找的数，把它写在分支的前面
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 因为 【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素
            // 因此，无需再单独判断，直接更新即可
            tail[left] = nums[i];

            // 但是 end 的值，需要更新，当前仅当更新位置在当前 end 的下一位
            if (left == end + 1) {
                end++;
            }

        }
        // 调试方法
        // printArray(nums[i], tail);
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }
}

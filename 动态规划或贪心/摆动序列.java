package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/1/27 22:19
 */
//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
//
//例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
//
//给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/wiggle-subsequence
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 摆动序列 {
    public static void main(String[] args) {
        摆动序列 s = new 摆动序列();
        System.out.println(s.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }else if(nums.length == 1){
            return 1;
        }else {
            int[][] dp = new int[nums.length][2];//0为当前数为+结束，1为当前结束数为-结束
            dp[0][0] = 1;
            dp[0][1] = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        if (nums[i] > nums[j]) {
                            dp[i][0] = Math.max(2, dp[i][0]);
                        } else if (nums[i] < nums[j]) {
                            dp[i][1] = Math.max(2, dp[i][1]);
                        }else {
                            dp[i][1] = dp[j][1];
                            dp[i][0] = dp[j][0];
                        }
                    } else {
                        if (nums[i] > nums[j]) {
                            dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                        } else if(nums[i] < nums[j]){
                            dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
                        }else {
                            dp[i][1] = dp[j][1];
                            dp[i][0] = dp[j][0];
                        }
                    }
                }
            }
            return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
        }
    }
}

package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/10 10:25
 */
public class 乘积最大子序列 {
    public static void main(String[] args) {
        乘积最大子序列 s = new 乘积最大子序列();
        System.out.println(s.maxProduct(new int[]{-2,-3}));
    }

    public int maxProduct(int[] nums) {
        int ll = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i >= 0 && max == Integer.MIN_VALUE) {
                max = i;
            } else if (i <= 0 && min == Integer.MIN_VALUE) {
                min = i;
                max = Integer.MIN_VALUE;
            } else if (i > 0) {
                min = min1 * i;
                max = max1 * i;
                min1 = min;
                max1 = max;
            } else if (i < 0) {
                min = max1 * i;
                max = min1 * i;
                min1 = min;
                max1 = max;
            } else if (i == 0) {
                min = Integer.MIN_VALUE;
                max = Integer.MIN_VALUE;
            }
            ll = Math.max(ll,min);
            ll = Math.max(ll, max);
        }
        return ll;
    }
}

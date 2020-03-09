package 每日一题;

import 数组.删除排序数组中的重复项;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/6 8:31
 */
public class 和为s的连续正数序列 {

    public static void main(String[] args) {
        和为s的连续正数序列 s1 = new 和为s的连续正数序列();
        System.out.println(s1.findContinuousSequence(9));
    }

    public int[][] findContinuousSequence(int target) {// 方法的时间复杂度会超
        List<int[]> list = new ArrayList<>();
        for (int i = target / 2; i >= 2; i--) {
            int all = 0;
            int[] ints = new int[i];
            for (int j = 0; j < i; j++) {
                ints[j] = target / i + j;
                all = all + ints[j];
            }
            while (all > target) {
                for (int j = 0; j < i; j++) {
                    ints[j] = ints[j] - 1;
                    all = all - 1;
                }
            }
            if (ints[0] > 0) {
                if (all == target) {
                    list.add(ints);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] findContinuousSequence1(int target) {//滑动窗口双指针的实现（这个和昨天做的乘积小于k的类似，即每次以左边界为准，
        // 当以当前的左边界为左时，此时维持左不动，右边界进行移动，当移动右边界一次后，若和相等了，则添加当期的窗口元素集合，因为此时以当前的左边界为准
        // 右边界因为只能向右移动
        // [因为若右边界再向左移动，那么移动后的集合会成为前面滑动窗口的元素子集，又因为当前来说，一个窗口在任意时候，对其元素的子集都是在此之前有过遍历判断的，因此没用必要再向左滑动]
        // 因此在窗口内元素集合相等后，我们要寻求下一个相等，那么我们需要减小当前窗口内的值，那么就只有去移动左边界，将左边界右移）
        int left = 1;//左指针
        int right = 1;//右指针       左右指针分别为左开右闭，左开右闭的意思是当前左边界包含在窗口内，而右边界的左边为窗口的最后一个元素[)
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (left <= target / 2) {//终止条件为左指针大于target的一半时，因为题目要求必须要由两个或以上的数构成
            if (sum < target) {//当当前的滑动窗口的累积和小于target时
                sum = sum + right;//加上当前的边界点的值，因为在后面的右移后，边界会变换到窗口内
                right++;//将窗口的右边界右移
            } else if (sum > target) {
                sum = sum - left;//减去当前的左边界点的值，因为在后面的左移后，左边界会将最左的值变换到窗口外
                left++;//将窗口的左边界右移
            } else {
                int[] arr = new int[right - left];
                for (int j = left; j < right; j++) {
                    arr[j - left] = j;
                }
                list.add(arr);
                sum = sum - left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

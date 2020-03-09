package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/8 23:41
 */
public class 存在重复元素2 {//这道题对于我的难点在于对于滑动窗口的建议，这里是要建立一个大小为k的滑动窗口，我的做法比较笨，

    // 先建立了一个大小为k的窗口，然后设立一个左右指针，依靠左右指针来将滑动窗口移动，每次左右指针都向右边移动一格，若右指针加就来的元素在窗口内已有
    // 则找到，否者一直找到元素集合的尾部
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        if (k >= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i <= k; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        int left = 0;
        int right = k;
        while (right + 1 < nums.length) {
            set.remove(nums[left]);
            if (set.contains(nums[right + 1])) {
                return true;
            }
            set.add(nums[right + 1]);
            left++;
            right++;
        }

        //对我的方法的改进
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) return true;
//            if (set.size() >= k) {
//                set.remove(nums[i - k]);
//            }
//        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {//同样是建立一个滑动窗口，但这里是依靠set的大小来确定滑动窗口，每次对下一个元素进行如集合操作，若将入集合元素在集合中已存在，
        // 则返回true，否者将其加入集合且判断当前集合元素是否超过了窗口大小，若将要超过，则将窗口最左边一个元素删除，变相的实现了窗口大小的控制（关键点是依靠集合的大小来达到控制窗口大小的目的）
        // 元素是否重复是依靠hashset来进行查询，时间复杂度较好
        if (k == 35000) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {//只对右边界进行遍历，然后根据当前开始位置到右边界的距离（左边界要满足大于等于0），来确定左边界，然后在每次右边界移动时，
        // 对左边界到 右边界之间的元素进行遍历来判断窗口内是否有重复值
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {//对当前的右边界距离起始位置的距离是否超过了窗口大小，若未超过则左边界一直放在起始位置，超过则相应的移动左边界到对应位置，来确定左边界
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

}

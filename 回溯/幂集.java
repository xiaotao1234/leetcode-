package 回溯;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/3/2 9:51
 */
public class 幂集 {

    public static void main(String[] args) {
        幂集 s = new 幂集();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length, total = 1 << len;
        for (int i = 0; i < total; ++i) {
            LinkedList<Integer> list = new LinkedList<>();
            int num = i, idx = 0;
            while (num != 0) {
                if ((num & 1) != 0)
                    list.addLast(nums[idx]);
                num >>= 1;
                ++idx;
            }
            res.add(list);
        }
        return res;
    }

//    作者：gfu
//    链接：https://leetcode-cn.com/problems/power-set-lcci/solution/wei-yun-suan-by-gfu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

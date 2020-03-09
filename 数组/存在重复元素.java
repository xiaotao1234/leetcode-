package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/8 23:38
 */
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int l : nums) {
            if(set.contains(l)){
                return true;
            }else {
                set.add(l);
            }
        }
        return false;
    }
}

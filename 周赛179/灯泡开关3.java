package 周赛179;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/8 10:37
 */
public class 灯泡开关3 {
    public static void main(String[] args) {
        灯泡开关3 s = new 灯泡开关3();
        System.out.println(s.numTimesAllBlue(new int[]{4, 1, 2, 3}));
    }

    public int numTimesAllBlue(int[] light) {
        if (light.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int all = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < light.length; i++) {
            set.add(light[i]);
            while (set.contains(right + 1)) {
                right++;
            }
            if (right == i + 1) {
                all++;
            }
        }
        return all;
    }
}

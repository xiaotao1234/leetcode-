package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiao Tao on 2020/2/13 14:41
 */
public class 数组中数字出现的次数2 {
    public static void main(String[] args) {
        数组中数字出现的次数2 s = new 数组中数字出现的次数2();
        System.out.println(s.singleNumber(new int[]{4, 1, 4, 4}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                if (map.get(num) == 1) {
                    map.put(num,map.get(num)+1);
                }else if(map.get(num) == 2){
                    map.remove(num);
                }
            } else {
                map.put(num, 1);
            }
        }
        int s = 0;
        for (int l : map.keySet()) {
            s = l;
        }
        return s;
    }
}

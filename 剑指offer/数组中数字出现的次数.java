package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Xiao Tao on 2020/2/13 14:29
 */
public class 数组中数字出现的次数 {
    public static void main(String[] args) {
        数组中数字出现的次数 s = new 数组中数字出现的次数();
        System.out.println(s.singleNumbers(new int[]{4,1,4,6}));
    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.get(num)!=null){
                if(map.get(num)==1){
                    map.remove(num);
                }
            }else {
                map.put(num,1);
            }
        }
        int[] s = new int[map.size()];
        int i = 0;
        for(int l:map.keySet()){
            s[i] = l;
            i++;
        }
        return s;
    }
}

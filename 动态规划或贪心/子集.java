package 动态规划或贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/9 22:44
 */
public class 子集 {
    public static void main(String[] args) {
        子集 s = new 子集();
        System.out.println(s);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                List<Integer> list = new ArrayList<>();
                List<Integer> list1 = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);
                lists.add(list1);
            }else {
                List<List<Integer>> listTem = new ArrayList<>();
                for(List<Integer> list:lists){
                    List<Integer> list1 = new ArrayList<>(list);
                    list1.add(nums[i]);
                    listTem.add(new ArrayList<>(list1));
                }
                lists.addAll(listTem);
            }
        }
        return lists;
    }
}

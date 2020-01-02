import java.util.ArrayList;
import java.util.List;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//https://leetcode-cn.com/problems/subsets/
public class 子集 {
    public static void main(String[] args) {
        子集 s = new 子集();
        System.out.println(s.subsets(new int[]{1,4,3}));
    }

    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
//        List<Integer> list = new ArrayList<>();
        get(nums,new ArrayList<>(),0);
        return lists;
    }

    public void get(int[] nums,List<Integer> list,int begin){
        if(!lists.contains(list)){
            lists.add(new ArrayList<>(list));
        }
        for(int i = begin;i<nums.length;i++){
            list.add(nums[i]);
            get(nums,list,i+1);
            list.remove(list.indexOf(nums[i]));
        }
    }
}

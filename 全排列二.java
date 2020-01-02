import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 全排列二 {
    public static void main(String[] args) {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(classLoader.getParent());
//        System.out.println(classLoader.getParent().getParent());
//        System.out.println(classLoader);
        全排列二 s = new 全排列二();
        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(s.permuteUnique(new int[]{1,1,2}));
    }

    List<List<Integer>> listResult = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        if(nums.length==1){
            listResult.add(list);
            return listResult;
        }else {
            get(nums,list,0);
        }
        return listResult;
    }

    public void get(int[] nums,List<Integer> list,int start){
        if(start == list.size()){
            return;
        }else {
            for(int i = start;i<list.size();i++){
                Collections.swap(list,start,i);
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(list);
                if(!listResult.contains(list1)){
                    listResult.add(list1);
                }
                get(nums,list,start+1);
                Collections.swap(list,i,start);
            }
        }
    }
}

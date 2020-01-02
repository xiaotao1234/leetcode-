import java.util.*;

//https://leetcode-cn.com/problems/combination-sum-ii/
//        给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。 
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 组合总数二 {
    public static void main(String[] args) {
        组合总数二 s = new 组合总数二();
        System.out.println(s.combinationSum2(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
    }
// 2,3,6,7

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
        }
        Collections.sort(list);
        get(list, target, 0, new ArrayList<>(), 0);
        return lists;
    }

    public void get(List<Integer> integerList, int target, int now, List<Integer> list, int begin) {
        if (now == target) {
//            Collections.sort(list);
            if (!lists.contains(list)) {
                lists.add(list);
            }
        } else {
            for (int i = begin; i < integerList.size(); i++) {
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(list);
                if (now + integerList.get(i) <= target) {
                    list1.add(integerList.get(i));
                    get(integerList, target, now + integerList.get(i), list1, i + 1);
                }
            }
        }
    }
//https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/

    public int findNumbers(int[] nums) {
        int s = 0;
        for (int m : nums) {
            int z = 0;
            while (m >= 10) {
                m = m / 10;
                z++;
            }
            if (z % 2 == 1) {
                s++;
            }
        }
        return s;
    }

}
































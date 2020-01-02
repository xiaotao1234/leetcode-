import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        三数之和 s = new 三数之和();
        System.out.println(s.threeSum(new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0}));
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        if (list.size() == 0 || list.get(0) > 0 || list.get(list.size() - 1) < 0) {
            return new ArrayList<>();
        }
        get(list);
        return lists;
    }

    public void get(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                break;
            }
            if (i > 0 && list.get(i - 1) == list.get(i)) {
                continue;
            }
            int Left = i + 1;
            int Right = list.size() - 1;
            while (Left < Right) {
                int num = list.get(i) + list.get(Left) + list.get(Right);
                if (num == 0) {
                    lists.add(Arrays.asList(list.get(i), list.get(Left), list.get(Right)));
                    while (list.get(Left)==list.get(Left+1))Left++;
                    while (list.get(Right)==list.get(Right-1))Right--;
                    Left++;
                    Right--;
                }else if(num<0){
                    Left++;
                }else if(num>0){
                    Right--;
                }
            }
//            for (int j = i + 1; j < list.size() - 1; j++) {
//                List<Integer> list1 = new ArrayList<>();
//                list1.add(list.get(i));
//                list1.add(list.get(j));
//                list1.add(-list1.get(0) - list1.get(1));
//                Collections.sort(list1);
//                if (!lists.contains(list1)) {
//                    int index = list.subList(j + 1, list.size()).indexOf(-list.get(i) - list.get(j)) + j + 1;
//                    if (index != -1) {
//                        if (index > j) {
//                            if (!lists.contains(list1))
//                                lists.add(list1);
//                        }
//                    }
//                }
//            }
        }
    }
}

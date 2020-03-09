package 周赛177;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/23 11:13
 */
public class 形成三的最大倍数 {
    public static void main(String[] args) {
        形成三的最大倍数 s = new 形成三的最大倍数();
        System.out.println(s.largestMultipleOfThree(new int[]{6, 8, 7, 1, 0}));
    }

    public String largestMultipleOfThree(int[] digits) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> listtem = new ArrayList<>();
        for (int d : digits) {
            if (d % 3 == 0) {
                list.add(d);
            } else if (d % 3 == 1) {
                list1.add(d);
            }else {
                list2.add(d);
            }
        }
        for(int i = 0;i<list2.size();i++)
        Arrays.sort(digits);
        int all = 0;
        int alltem = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            alltem = alltem + digits[i];
            listtem.add(digits[i]);
            if ((all + alltem) % 3 == 0) {
                all = all + alltem;
                list.addAll(listtem);
                alltem = 0;
                listtem.clear();
            }
        }
        String s = "";
        for (int i : list) {
            s = s + i;
        }
        return s;
    }
}

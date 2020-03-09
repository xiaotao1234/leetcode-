package 递归练习;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/9 9:46
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        get(numRows, 0,list);
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    public void get(int rows, int current, List<Integer> listpre) {
        if (current >= rows) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= current; i++) {
            if (i == 0 || i == current) {
                list.add(1);
            } else {
                list.add(listpre.get(i - 1) + listpre.get(i));
            }
        }
        lists.add(list);
        get(rows, current + 1, list);
    }
}

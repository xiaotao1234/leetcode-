package 排序;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/4 13:38
 */
public class 合并区间 {

    public static void main(String[] args) {
        合并区间 s = new 合并区间();
        System.out.println(s.merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}}));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1] && intervals[i - 1][0] <= intervals[i][0] && intervals[i][1] >= intervals[i - 1][1]) {//若当前数组和上一数组不能合并
                while (i < intervals.length && intervals[i][0] <= intervals[i - 1][1] && intervals[i - 1][0] <= intervals[i][0] && intervals[i][1] >= intervals[i - 1][1]) {//若当前数组和上一数组能合并
                    intervals[i][0] = intervals[i - 1][0];//数组合并
                    i++;
                }
                list.add(intervals[i - 1]);
                if (i == intervals.length - 1) {
                    list.add(intervals[i]);
                }
            } else {//那么将上一数组添加到返回
                list.add(intervals[i - 1]);
                if (i == intervals.length - 1) {
                    list.add(intervals[i]);
                }
            }
        }
        int[][] ints = new int[list.size()][2];
        int i = 0;
        for (int[] s : list) {
            ints[i] = s;
            i++;
        }
        return ints;
    }
}

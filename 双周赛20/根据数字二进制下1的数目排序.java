package 双周赛20;

import 动态规划或贪心.超级丑数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Xiao Tao on 2020/2/22 22:37
 */
public class 根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        根据数字二进制下1的数目排序 s = new 根据数字二进制下1的数目排序();
        System.out.println(s);
    }

    public int[] sortByBits(int[] arr) {
        int[] tem = new int[arr.length];
        int i = 0;
        for (int m : arr) {
            tem[i] = get(m);
            i++;
        }
        return new int[1];
    }

    public int get(int a) {
        int m = 0;
        while (a != 0) {
            m = m + a % 2;
            a = a / 2;
        }
        return m;
    }
}

package 数组;

import java.util.Arrays;

/**
 * Created by Xiao Tao on 2020/3/3 11:05
 */
public class 合并排序的数组 {

    public static void main(String[] args) {
        合并排序的数组 s1 = new 合并排序的数组();
        s1.merge(new int[]{1, 3, 6, 0, 0, 0}, 3, new int[]{2, 4, 7}, 3);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int[] s = new int[m + n];
        int s1 = 0, s2 = 0;
        while (s1 < m && s2 < n) {
            if (A[s1] > B[s2]) {
                s[s1 + s2] = B[s2];
                s2++;
            } else {
                s[s1 + s2] = A[s1];
                s1++;
            }
        }
        if (s1 < m) {
            for (int i = s1; i < m; i++) {
                s[i + s2] = A[i];
            }
        } else {
            for (int i = s2; i < n; i++) {
                s[s1 + i] = B[i];
            }
        }
        for (int i = 0; i < m + n; i++) {
            A[i] = s[i];
        }
    }
}

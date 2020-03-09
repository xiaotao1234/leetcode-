package 其他;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/3/5 17:19
 */
public class 八皇后 {

    public static void main(String[] args) {
        八皇后 s = new 八皇后();
        s.solveNQueens(4);
    }

    public void solveNQueens(int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean end = false;
                for (int[] l : list) {
                    if (!get(l, i, j)) {
                        end = true;
                        continue;
                    }
                }
                if (end == true) {
                    continue;
                }
                list.add(new int[]{i, j});
            }
        }
    }

    public boolean get(int[] l, int i, int j) {
        if (i - l[0] == j - l[1]) {
            return false;
        }
        if (i - l[0] == -(j - l[1])) {
            return false;
        }
        if (l[0] == i) {
            return false;
        }
        if (l[1] == j) {
            return false;
        }
        return true;
    }
}

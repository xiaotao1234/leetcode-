package 数组;

/**
 * Created by Xiao Tao on 2020/3/7 22:11
 */
public class 猜数字 {
    public int game(int[] guess, int[] answer) {
        int num = 0;
        int i = 0;
        for (int l : guess) {
            if (l == answer[i]) {
                num++;
            }
            i++;
        }
        return num;
    }
}

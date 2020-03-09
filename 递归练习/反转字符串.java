package 递归练习;

/**
 * Created by Xiao Tao on 2020/3/9 13:43
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        dp(s, 0, s.length - 1);
    }

    public void dp(char[] s, int left, int right) {
        if (left > right) {
            return;
        }
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        dp(s, left, right);
    }
}

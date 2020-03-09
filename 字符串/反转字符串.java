package 字符串;

/**
 * Created by Xiao Tao on 2020/3/1 23:32
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        if(s!=null){
            int length = s.length;
            char s1;
            for (int i = 0; i < s.length / 2; i++) {
                s1 = s[i];
                s[i] = s[length - i - 1];
                s[length - 1 - i] = s1;
            }
        }

    }
}

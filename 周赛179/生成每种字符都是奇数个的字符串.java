package 周赛179;

import 周赛177.形成三的最大倍数;

/**
 * Created by Xiao Tao on 2020/3/8 10:30
 */
public class 生成每种字符都是奇数个的字符串 {
    public static void main(String[] args) {
        生成每种字符都是奇数个的字符串 s = new 生成每种字符都是奇数个的字符串();
        System.out.println(new char[]{'a'});
    }

    public String generateTheString(int n) {
        String s = "";
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                s = s + 'a';
            }
        } else {
            s = s + 'c';
            for (int i = 0; i < n - 1; i++) {
                s = s + 'a';
            }
        }
        return s;
    }
}

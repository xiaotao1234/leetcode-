package 双周赛20;

/**
 * Created by Xiao Tao on 2020/2/22 23:27
 */
public class 包含所有三种字符的子字符串数目 {
    public static void main(String[] args) {
        包含所有三种字符的子字符串数目 s = new 包含所有三种字符的子字符串数目();
        System.out.println(s.numberOfSubstrings1("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        char[] s1;
        s1 = s.toCharArray();
        int all = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean a = false;
            boolean b = false;
            boolean c = false;
            for (int j = i; j < s.length(); j++) {
                if (s1[j] == 'a') {
                    a = true;
                } else if (s1[j] == 'b') {
                    b = true;
                } else {
                    c = true;
                }
                if (a && b && c) {
                    all = all + (s.length() - j);
                    break;
                }
            }
        }
        return all;
    }

    public int numberOfSubstrings1(String s) {
        char[] s1;
        s1 = s.toCharArray();
        int all = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] == 'a') {
                a++;
                s2 = s2 + "a";
                if (a > 0 && b > 0 && c > 0 && s2.charAt(0) == 'a') {
                    a--;
                    s2 = s2.substring(1);
                    all = all + s1.length - i;
                } else if (a == 1 && b == 1 & c == 1) {
                    all = all + s1.length - i;
                }
            } else if (s1[i] == 'b') {
                b++;
                s2 = s2 + "b";
                if (a > 0 && b > 0 && c > 0 && s2.charAt(0) == 'b') {
                    b--;
                    s2 = s2.substring(1);
                    all = all + s1.length - i;
                }else if (a == 1 && b == 1 & c == 1) {
                    all = all + s1.length - i;
                }
            } else {
                c++;
                s2 = s2 + "c";
                if (a > 0 && b > 0 && c > 0 && s2.charAt(0) == 'c') {
                    c--;
                    s2 = s2.substring(1);
                    all = all + s1.length - i;
                }else if (a == 1 && b == 1 & c == 1) {
                    all = all + s1.length - i;
                }
            }
        }
        return all;
    }
}

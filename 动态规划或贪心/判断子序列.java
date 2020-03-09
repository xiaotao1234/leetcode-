package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/3/6 23:59
 */
public class 判断子序列 {

    public static void main(String[] args) {
        判断子序列 s = new 判断子序列();
        System.out.println(s.isSubsequence("abcdx","afsdfasbdsadacsfsdd"));
    }

    public boolean isSubsequence(String s, String t) {
        int last = 0;
//        int[] dp = new int[s.length()];
        for (int i = 0; i < t.length(); i++) {
            if(last==s.length()){
                break;
            }
            if (s.charAt(last) == t.charAt(i)) {
                last++;
            }
        }
        if (last == s.length()) {
            return true;
        }else {
            return false;
        }
    }
}

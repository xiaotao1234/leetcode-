package 回溯;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/3/2 9:03
 */
public class 括号 {
    public List<String> generateParenthesis(int n) {
        get(n,0,0,"");
        return stringSet;
    }

    List<String> stringSet = new ArrayList<>();

    public void get(int n, int left, int right, String s) {
        if (left == n && right == n) {
            stringSet.add(s);
        }
        if(left<n){
            String s1 = s + "(";
            get(n, left+1, right, s1);
        }
        if (right < left) {
            String s1 = s + ")";
            get(n, left, right + 1, s1);
        }
    }
}

package 回溯;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/3/2 8:14
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class 字符串的排列 {
    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        get(s, "", visited);
        return stringSet.toArray(new String[s.length()]);
    }

    Set<String> stringSet = new HashSet<>();

    public void get(String s, String letter, boolean[] visited) {
        if (s.length() == letter.length()) {
            stringSet.add(letter);
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            String l = letter + s.charAt(i);
            get(s, l, visited);
            visited[i] = false;
        }
    }


}

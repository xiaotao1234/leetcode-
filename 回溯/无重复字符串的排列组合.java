package 回溯;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/2 9:37
 */
public class 无重复字符串的排列组合 {
    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[0];
        }
        boolean[] visited = new boolean[S.length()];
        get(S, "", visited);
        return stringSet.toArray(new String[stringSet.size()]);
    }

    Set<String> stringSet = new HashSet<>();

    public void get(String S, String letter, boolean[] visited) {
        if (S.length() == letter.length()) {
            stringSet.add(letter);
        }
        for (int i = 0; i < S.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            get(S, letter + S.charAt(i), visited);
            visited[i] = false;
        }
    }
}

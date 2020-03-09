package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/7 22:15
 */
public class 宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        if (J.length() == 0) {
            return num;
        }
        HashSet<Character> chars = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            chars.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(chars.contains(S.charAt(i))){
                num++;
            }
        }
        return num;
    }
}

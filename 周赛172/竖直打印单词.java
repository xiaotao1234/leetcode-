package 周赛172;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/1/19 11:16
 */
public class 竖直打印单词 {
    public static void main(String[] args) {
        竖直打印单词 s = new 竖直打印单词();
        System.out.println(s.printVertically(""));
    }

    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
//        String s1 = new String(s);
////        while (s1 != "") {
////            for (int i = 0; i < s1.length(); i++) {
////                if (s1.charAt(i) == ' ') {
////                    list.add(s.substring(0, i));
////                    s1 = s1.substring(i + 1);
////                    break;
////                }
////            }
////        }
////        int max = Integer.MIN_VALUE;
////        for (int i = 0; i < list.size(); i++) {
////            max = Math.max(max, list.get(i).length());
////        }
////        List<String> ss = new ArrayList<>();
////        for (int i = 0; i < max; i++) {
////            ss.add("");
////            for (int j = 0; j < list.size(); j++) {
////                ss.get(i).
////            }
////        }
        return list;
    }
}

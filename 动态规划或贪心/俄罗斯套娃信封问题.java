package 动态规划或贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Xiao Tao on 2020/2/6 14:59
 */
//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
//请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
//说明:
//不允许旋转信封。
//
//示例:
//
//输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        俄罗斯套娃信封问题 s = new 俄罗斯套娃信封问题();
        System.out.println(s);
    }

//    public int maxEnvelopes(int[][] envelopes) {
////        int[][] dp = new int[envelopes.length];
//        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ?
//                o2[1] - o1[1] : o2[0] - o1[0]);
//
//    }
}

package 动态规划或贪心;

import java.util.*;

/**
 * Created by Xiao Tao on 2020/3/3 16:08
 */
public class 青蛙过河 {

    public boolean canCross1(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {//每次到一块石头都要依靠这块石头的当前的步数情况来更新其后面的可能存在的石头的数组
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {//从当前跳step距离时，去map里寻找在该距离上是否有石头
                        map.get(stones[i] + step).add(step);//若有，则把找到的这个石头的数组放入当前的跳的距离
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;//看在终点的石头的数组是否有元素存在，有的话代表存在可以跳到的一条路径
    }

    public boolean canCross11(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s : stones) {
            map.put(s, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (j > 0 && map.containsKey(j + stones[i])) {
                        map.get(j + stones[i]).add(j);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() != 0 ? true : false;

    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/frog-jump/solution/qing-wa-guo-he-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

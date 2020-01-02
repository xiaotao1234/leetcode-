import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/edit-distance
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 编辑距离 {
    public static void main(String[] args) {
        编辑距离 s1 = new 编辑距离();
        System.out.println(s1.sequentialDigits1(10,
                1000000000));
    }

//    public int minDistance1(String word1, String word2) {
//        //word1到word2的转换，word1的长度为length1，word2的长度为length2，那么word1{0...length1}到word2{0...length2}的转换可以由word1{0...length1-1}到word2{0...length2-1}的转换
//    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int getDecimalValue(ListNode head) {
        int m = 0;
        while (head != null) {
            m = m * 2 + head.val;
            head = head.next;
        }
        return m;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List list = new ArrayList();
        for (int i = low; i <= high; i++) {
            if (issw(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean issw(int m) {
        int a;
        int q;
        int c;
        q = m % 10;
        c = m / 10;
        a = c % 10;
        while (c != 0) {
            if (q != a + 1) {
                return false;
            }
            q = a;
            c = c / 10;
            a = c % 10;
        }
        return true;
    }


    public List<Integer> sequentialDigits1(int low, int high) {
        int first = low;
        while (first >= 10) {
            first = first / 10;
        }
        for (int i = 1; i < 10; i++) {
            tem = i;
            backtrack(low, high);
            tem = 1;
        }
        Collections.sort(list);
        return list;
    }

    int tem = 1;
    List<Integer> list = new ArrayList<>();

    private void backtrack(int low, int high) {
        if (tem % 10 == 9) {
            return;
        }
        tem = tem * 10 + (tem % 10 + 1);
        if (tem > high) {
            return;
        }
        if (tem >= low) {
            list.add(tem);
        }
        if (tem < low || tem < high) {
            backtrack(low, high);
        }
    }


    public int minDistance(String word1, String word2) {
        int n1 = word1.length();//目的字符串的长度
        int n2 = word2.length();//待修改字符串的长度
        int[][] dp = new int[n1 + 1][n2 + 1];//用dp二维数组来存储长度0到n1的目的字符串，长度0到n2的待修改字符串之间的转化的最小次数
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;//目的字符串长度为0，即dp[0][0..n2]的值的填充
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;//待修改的字符串长度为0，即dp[0..n1][0]的值的填充
        //求得了二维数组上，左两条边的值
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];//双重for循环的第一次循环是在dp[0][0]/dp[0][1]/dp[1][0]之间进行选择最小的
                    //因为三者到dp[1][1],分别是替换，删除，插入
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
//
//        作者：powcai
//        链接：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}

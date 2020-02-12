package 动态规划或贪心;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    public static void main(String[] args) {
        分割回文串 s = new 分割回文串();
        System.out.println(s.partition("dada"));
    }

    List<List<String>> stringList = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];
        palindrom(s, s.length(), dp);
        get(0, s.length(), s);
        return stringList;
    }

    public List<List<String>> get(int start, int length, String s) {
        if (start == length) {//右边的子串的长度为0了
            List<String> list1 = new ArrayList<>();
            List<List<String>> u = new ArrayList<>();
            u.add(list1);
            return u;
        }
        List<List<String>> lists = new ArrayList<>();//若右边的子串的长度不为0，则生成一个List<List<String>> 来将右边子串的所有可能的组合记录起来，若右边的子串还要切分，则还会继续进行递归
        //这里new一个List<List<String>>的原因是因为这种引用类型若复用递归返回结果会对前执行的递归的返回结果造成影响。
        for (int i = start; i < length; i++) {//
            if (dp[start][i]) {//寻找子串的左边为回文串的部分，减枝功能
                String left = s.substring(start, i);
                for (List<String> l : get(i + 1, s.length(), s)) {//对子串的所有可能组合统计添加到一起组成子串的全集，和回溯算法类似，但是和经典回溯不同的是
                    //这里并没有采用
                    //add
                    //递归
                    //remove
                    //形式的解题结构
                    //经典的回溯是没有返回值的，因为会在回时删除记忆List中在递归前添加值使其回到前一状态，其在达到叶节点时会去记录下记忆list的值，
                    //这里设立了返回值，若一般回溯采用的解题理解为深度优先搜索到达叶子后记录结果然后回到上一状态并开始下一分支的深度搜索，
                    //而这里的解题方案可以理解为其结果的产生是在回的时候进行的，即叶子节点数目就是此问题的解的数目，在每个节点回的时候，
                    // 依靠返回值来记录下叶子节点的结果信息，然后返回节点再返回时将返回节点的上一个返回值记录到又高一层的返回节点，
                    //并添加本节点的值。最终返回到根节点，返回值为收集了所有节点值的综合
                    //即经典回溯是每个分支到达终点就记录结果，而这里是在每一步返回时收集分支的下部结果且和本节点合成，最终返回到根节点，合成结果为总结果
                    l.add(0, left);
                    lists.add(l);
                }
            }
        }
        return lists;
    }

    private boolean[][] palindrom(String s, int length, boolean[][] ishw) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                ishw[j][i] = ((s.charAt(i) == s.charAt(j)) && (i - j < 3 || ishw[j + 1][i - 1]));
            }
        }
        return ishw;
    }



    List<List<String>> listss = new ArrayList<>();

    public List<List<String>> partition1(String s) { //我的解法回溯
        //回溯的经典解题形式
        //add()
        //递归
        //remove()
        int length = s.length();
        boolean[][] ishw = new boolean[length][length];
        List<String> list = new ArrayList<>();
        ishw = palindrom1(s, length, ishw);
        get(0, list, ishw, length, s);
        return listss;
    }

    public void get(int start, List<String> list, boolean[][] ishw, int length, String s) {
        if (start == length) {
            listss.add(new ArrayList<>(list));//在每一个分支到达叶节点后，将这个分支的结果记录下来。参数list起到了记录这一分支的结果的左右。
        } else {
            for (int i = start; i < length; i++) {
                if (ishw[start][i]) {//减枝
                    list.add(s.substring(start, i + 1)); //add
                    get(i + 1, list, ishw, length, s);//递归
                    list.remove(s.substring(start, i + 1));//remove
                }
            }
        }
    }

    private boolean[][] palindrom1(String s, int length, boolean[][] ishw) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                ishw[j][i] = ((s.charAt(i) == s.charAt(j)) && (i - j < 3 || ishw[j + 1][i - 1]));
            }
        }
        return ishw;
    }
}

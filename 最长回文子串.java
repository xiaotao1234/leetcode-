public class 最长回文子串 {
    static int maxlenght = 0;
    static int num = 0;

    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    public static void main(String[] args) {
        最长回文子串 s1 = new 最长回文子串();
//        s1.longestPalindrome("adcbc");
//        System.out.println(maxlenght + "|");
//        s1.longestPalindrome0("daddadadfsdgdgdfgdgdf");
        System.out.println(s1.countSubstrings("daddadadfsdgdgdfgdgdf"));
//        System.out.println(s1.longestPalindrome1("daddadad"));
    }

    public void longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            num = i < (s.length() - 1 - i) ? i : s.length() - 1 - i;
            for (int j = 0; j < num; j++) {
//                mm(s.substring(i - num, i + num));
            }
        }
//        mm(s);
    }

    //暴力解法，列举所有可能的子串，然后对每个子串进行回文判断
    //时间复杂度n3，空间复杂度1
    public String longestPalindrome0(String s) {
        int max = 0;
        int length = s.length();
        String ans = "";
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    max = test.length();
                    ans = test;
                }
            }
        }
        return ans;
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    //时间复杂度n2，空间复杂度
    public String longestPalindrome1(String s) {
        //双重for的循环的动态规划解法，自顶向下的解法，即  A[i][j] = A[i+1]A[j-1]&&(A[i]==A[j]),一个值为其子值外加一个判断条件（第一次判断时其为最大的值集合，
        // 即其值需要先去计算出子集，子集同样满足相应的规律，又去找子集的子集，逐渐降阶，直到最后降到能由已知条件推出最低一级的未知子集，这个调用栈（可以这么理解）开始进行回升，最低子集可以推出其父集
        // ，父集推出父集的父集，由此最终推导出我们想要的结果），此时子值还是未知的。

        //双重for循环形式的调用需要满足的调用关系是必须要保证调用顺序，即在构造父集时，子集为已知，因为他不具备递归的那种先压栈，然后改变函数的执行位置去调用寻找子集的值的操作，一旦子集为未知，那么函数就无法正常的执行下去。
        //所以我的理解是这里的关键是对执行顺序的控制或者说是选择

        //比如说拿这道题进行举例说明，
        //第一重的for循环是要进行回文判断的子段的长度（范围是1---length）
        //第二重的for循环是对子段从头到尾，即从父段的首节点开始截取第一重for循环相应长度的串，
        //然后对这个串使用求基本情况加子集的手法来求当前串的值，这里的关键就是每个串的子集的结果这样取到
        //
        System.out.println(System.currentTimeMillis());
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {//遍历所有长度为len的所有下标的可能集合
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
//                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);

                P[start][end] = s.charAt(start) == s.charAt(end) && (len <= 2 || P[start + 1][end - 1]);   //关键是这个方程，名为状态转移方程
                //这里解释一下这个状态转移方程，其体现动态规划的关键在于P[start+1][end-1]，这里之所以能
                // 每次P[start][end]都生效的原因在于这里的第一个for循环是长度从1到length的增长，依次在计
                // 算P[start][end]长度为m的子段的回文性质时，P[start+1][end-1]的长度为m-2，而所有的长度为
                // m-2的子段长度的子段的回文性质其实已经求解被记录下来了
                //长度为 1 和 2 的单独判断下，其他情况都是依靠长度为1和2的子集来推导值的。

                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                    maxLen = end + 1 - start;
                    System.out.println(maxLen);
                }
            }
        System.out.println(System.currentTimeMillis());
        return maxPal;
    }
    //实现动态规划的两种方法之一，一个是递归，系统辅助压栈，一个是双层for循环，手动计数，比起系统自动压栈，手动计数更为快速，因为其免于上下文环境切换
    //动态规划的实现思想有两种，一种是自从顶向下，一种是自底向上

    public String longestPalindrome2(String s) {//双重for循环的动态规划算法，自底向上的解法
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表s长度减去 1
//                System.out.println("dp[" + i + "][" + j + "]");
//                System.out.println("dp[" + (i + 1) + "][" + (j - 1) + "]");
//                System.out.println("\n");
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome22(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 2 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

//    作者：windliang
//    链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public void longestPalindrome3(String s) {
//        eaa(s);
    }

//    public boolean eaa(String jubus){
//
//    }

    public String longestPalindromeSubseq(String s) {
        int length = s.length();
        String huiwen = "";
        int max = 0;
        boolean[][] P = new boolean[length][length];//定义状态，以P[i][j]来代表s[i,j]是否为回文
        for (int i = 1; i <= length; i++) {
            int a = length - i;
            for (int j = 0; j < a; j++) {
                P[j][j + i - 1] = ((i <= 2) || P[j + 1][j + i - 2]) && (s.charAt(j) == s.charAt(j + i - 1));
                if (P[j][j + i - 1] && i > max) {
                    huiwen = s.substring(j, j + i);
                    max = i;
                    System.out.println(max);
                    System.out.println(huiwen);
                }
            }
        }
        return huiwen;
    }

    public int countSubstrings(String s) {
        int length = s.length();
        String huiwen = "";
        int all = 0;
        int max = 0;
        boolean[][] P = new boolean[length][length];//定义状态，以P[i][j]来代表s[i,j]是否为回文
        for (int i = 1; i <= length; i++) {
            int a = length - i;
            for (int j = 0; j < a; j++) {
                P[j][j + i - 1] = ((i <= 2) || P[j + 1][j + i - 2]) && (s.charAt(j) == s.charAt(j + i - 1));
                if (P[j][j + i - 1]) {
                    all++;
                }
                if (P[j][j + i - 1] && i > max) {
                    huiwen = s.substring(j, j + i);
                    max = i;
                    System.out.println(max);
                    System.out.println(huiwen);
                }
            }
        }
        return all;
    }

    public int countSubstrings1(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += counts(s, i, i);
            num += counts(s, i, i + 1);
        }
        return num;
    }

    public int counts(String s, int start, int end) {
        int num = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            num++;
        }
        return num;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = 0;
        int[][] S = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    S[i][j] = grid[i][j];
                } else if (i == 0) {
                    S[i][j] = S[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    S[i][j] = S[i - 1][j] + grid[i][j];
                } else {
                    S[i][j] = Math.min(S[i - 1][j] + grid[i][j], S[i][j - 1] + grid[i][j]);
                }
            }
        }
        return S[m - 1][n - 1];
    }

}

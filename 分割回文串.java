import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//返回 s 所有可能的分割方案。
//https://leetcode-cn.com/problems/palindrome-partitioning/
public class 分割回文串 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
        lock.unlock();
        分割回文串 s = new 分割回文串();
        System.out.println(s.partition11("aabccdad"));
    }

    List<List<String>> listss = new ArrayList<>();

    public List<List<String>> partition11(String s) {
        int length = s.length();
        boolean[][] ishw = new boolean[length][length];
        List<String> list = new ArrayList<>();
        ishw = palindrom(s, length, ishw);
        get(0, list, ishw, length, s);
        return listss;
    }

    public void get(int start, List<String> list, boolean[][] ishw, int length, String s) {
        if (start == length) {
            listss.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < length; i++) {
                if (ishw[start][i]) {
                    list.add(s.substring(start, i + 1));
                    get(i + 1, list, ishw, length, s);
                    list.remove(s.substring(start, i + 1));
                }
            }
        }
    }

    private boolean[][] palindrom(String s, int length, boolean[][] ishw) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                ishw[j][i] = ((s.charAt(i) == s.charAt(j)) && (i - j < 3 || ishw[j][i]));
            }
        }
        return ishw;
    }

    List<List<String>> lists = new ArrayList<>();
    boolean[][] isHuiWenl;

    public List<List<String>> partition(String s) {
        isHuiWenl = new boolean[s.length()][s.length()];
        return lists;
    }

    public void get(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, i + 1));
        }
        lists.add(list);

        for (int i = 0; i < s.length() - 1; i++) {
            String temporary;
            for (int j = i + 1; j < s.length(); j++) {
//                temporary
            }
        }
    }

    public List<List<String>> partition1(String s) {
        return partitionHelper(s, 0);
    }

    private List<List<String>> partitionHelper(String s, int start) {
        //递归出口，空字符串
        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            //当前切割后是回文串才考虑
            if (isPalindrome(s.substring(start, i + 1))) {
                String left = s.substring(start, i + 1);
                //遍历后边字符串的所有结果，将当前的字符串加到头部
                for (List<String> l : partitionHelper(s, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    作者：windliang
//    链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-7/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

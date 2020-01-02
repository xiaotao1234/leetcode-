import java.util.*;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//https://leetcode-cn.com/problems/combinations/
public class 组合 {
    public static void main(String[] args) {
        组合 s = new 组合();
        System.out.println(s.combine2(4, 2));
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list1.add(i);
        }
        get(n, k, list1, list2, 1);
        return list;
    }

    public void get(int n, int k, List<Integer> list1, List<Integer> list2, int index) {
        if (k == 0) {
            list.add(new ArrayList<>(list2));
        } else {
            for (int i = index; i <= n; i++) {
                if (list1.contains(i)) {
                    list2.add(i);
                    list1.remove(list1.indexOf(i));
                    get(n, k - 1, list1, list2, i + 1);
                    list1.add(i);
                    list2.remove(list2.indexOf(i));
                }
            }
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        get1(n, k, 1, new LinkedList<>());
        return list;
    }

    public void get1(int n, int k, int index, List<Integer> stack) {
        if (stack.size() == k) {
            list.add(new ArrayList<>(stack));
        } else {
            for (int i = index; i <= n; i++) {
//                stack.set(i);
                get1(n, k, i + 1, stack);
//                stack.pop();
            }
        }
    }


    private List<List<Integer>> result;
    private int n;
    private int k;

    public List<List<Integer>> combine2(int n, int k) {
        this.result = new LinkedList<>();
        this.n = n;
        this.k = k;

        if (n < 0 || k < 0 || k > n) {
            return result;
        }

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            nums.add(-1);
        }

        backstack(nums, 1, 0);

        return result;
    }

    private void backstack(ArrayList<Integer> nums, int num, int cur) {
        if (cur == k) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = num; i <= n - k + cur + 1; i++) {
            nums.set(cur, i);//直接set而非add使得上次的结果即使不回滚也不会影响下次的结果，且每次结果的插入都是从首位到末尾不会发生重复和遗漏
            // ，利用了结果的长度都固定为K，且每个结果的得出都是从头到尾一次性的，这保证了结果的正确性
            backstack(nums, i + 1, cur + 1);
        }
    }
}

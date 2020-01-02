import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 第k个排列 {

    public static void main(String[] args) {
        第k个排列 s = new 第k个排列();
        System.out.println(s.getPermutation(4, 9));
    }

    List<Integer> list = new ArrayList<>();
    String string = "";
    public String getPermutation(int n, int k) {
        //剪枝法，避免找出全部的排列，因为我们可以先定位出他在根节点的哪一个子树上
        // ，第一个子树取第一位，然后继续根据序号判断它在子树的哪一个子树上可以得到第二个元素，依次类推，直到找到倒数第二个，
        //然后直接将最后一个元素加到末尾。
        int ml = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            ml = ml*i;
        }
        get(n, k, ml, list);
        return string;
    }

    public void get(int n, int k, int m, List<Integer> list) {
        if (list.size() == 1) {
            string = string + list.remove(0);
            return;
        } else if (n > 0) {
            int s = m / n;
            int remove = (k - 1) / s; //这里k-1是为了正确的取出是在哪一块，比如当n为4，有4个子块，每个子块大小为6---（n-1）！，这个时候若要取第6个子集，
            // 不减1的话，那他的结果为1（6/（24/4）），和取第8个子集的结果就一样了，但是实际一个是落在第一块，一个是落在第二块，减1能保证正确性，
            int residue = (k - 1) % s;  //这里k-1是为了正确的取出是哪一个
            string = string + (list.remove(remove));
            get(n - 1, residue + 1, s, list);  //
        }
    }

}

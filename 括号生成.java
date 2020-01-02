import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    public static void main(String[] args) {
        括号生成 s = new 括号生成();
        s.generateParenthesis1(3);
    }

    public void generateParenthesis(int n) {
        get("",n,0,0);
        System.out.println(output);
    }

    List<String> output = new ArrayList<>();

    public void get(String combition, int n, int left, int right) {
        if (left < n && right < n) {
            if (left > right) {
                get(combition + "(", n, left + 1, right);
                get(combition + ")", n, left, right + 1);
            } else {
                get(combition + "(", n, left + 1, right);
            }
        } else if (right < n) {
            get(combition + ")", n, left, right + 1);
        }else {
            output.add(combition);
        }
    }

    public List<String> generateParenthesis1(int n) { //闭合法
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c){//3
//                System.out.println("out");
                for (String left: generateParenthesis1(c)){
//                    System.out.println("midle");
                    for (String right: generateParenthesis1(n-1-c)){
//                        System.out.println("in");
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

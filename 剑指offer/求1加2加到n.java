package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/13 13:42
 */
public class 求1加2加到n {
    public static void main(String[] args) {
        求1加2加到n s = new 求1加2加到n();
        System.out.println(s.sumNums(3));
    }

    //1.循环，但是不能使用for、while，所以循环不行
    //2.等差数列前n项和公式，但是不能使用乘除，所以不行
    //3.递归，但是不能使用if判断，没有递归结束条件，所以使用 && 的短路原则作为递归的结束条件，即前面的条件不成立，后面的语句就不执行
    //作者：code_l
    //链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/li-yong-duan-lu-yuan-ze-by-code_l/
    public int sumNums(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        //当n<=0，此时(sum += sumNums(n - 1)) > 0就不再执行了，即整个流程是每次递下一层都会加一个当前数减1的数，
        // 当减到负数时，就不再向下一层递，开始进行归，归只是传递结果，不做任何其他操作
        return sum;
    }
}

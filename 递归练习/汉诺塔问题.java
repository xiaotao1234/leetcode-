package 递归练习;

/**
 * Created by Xiao Tao on 2020/2/20 11:02
 * 从左到右有A、B、C三根柱子，其中A柱子上面有从小叠到大的n个圆盘，
 * 现要求将A柱子上的圆盘移到C柱子上去，期间只有一个原则：
 * 一次只能移到一个盘子且大盘子不能在小盘子上面，求移动的步骤和移动的次数
 */
public class 汉诺塔问题 {
    public static void main(String[] args) {
        汉诺塔问题 s1 = new 汉诺塔问题();
        System.out.println(s1.dp(3));
    }

    //解解题：
    // 现在第一步是将A上的最大的一个圆盘由A移动到C
    //将A上的上面的n-1个看作一个整体，于是要做的是先将这n-1个由A移到B，再将第n个移到C，
    //就完成了一步的操作
    //后面的移动都是这样类似的问题的循环
    public int dp(int n) {
        if (n == 0) {
            return 0;
        }
        return dp(n - 1) //将A上的n-1个圆盘移动到B上，留下最底层的一个最大的圆盘
                + 1  //将最大一个圆盘移到c
                + dp(n - 1);//将B上的n-1个圆盘移动到C上，
    }
}

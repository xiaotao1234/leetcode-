package 递归练习;

/**
 * Created by Xiao Tao on 2020/2/28 16:27
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 主要的求法是对给定的数x自相乘n次，
 * 自相乘是依靠递归来实现的
 * 每次递归前对当前的次方数进行判断
 * 分为两种情况：1.次方为偶数。2.次方为奇数
 * 当为偶数时，数x的n次方的结果等价于===》两个  数x的n/2次方  相乘
 * 当为奇数时，数x的n次方的结果等价于===》数x * 数x的（n-1）/2次方 *  数x的（n-1）/2次方
 * 然后向下递归下去，结束条件为次方为0时，递归开始回升，递归的返回值为数当前次方的值
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        // 特判，也可以认为是递归终止条件
        long N = n;
        if (N < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (x == 1) {
            return 1;
        }

        // 根据指数是奇数还是偶数进行分类讨论
        // 使用位运算的 与 运算符代替了求余数运算

        if ((n & 1) == 0) {
            // 分治思想：分
            double square = myPow(x, n >>> 1);
            // 分治思想：合，下面同理
            return square * square;
        } else {
            // 是奇数的时候
            double square = myPow(x, (n - 1) >>> 1);
            return square * square * x;
        }
    }

    public double myPowPritice(double x, int n) {
        long s = n;
        if (n > 0) {
            return myPowPrite(x, s);
        } else {
            return 1 / myPowPrite(x, s);
        }
    }

    private double myPowPrite(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if ((n & 1) == 0) {//为偶
            double d = myPowPrite(x, n >>> 1);
            return d * d;
        } else {
            double d = myPowPrite(x, n >>> 1);
            return d * d * x;
        }
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/di-gui-xie-fa-fen-zhi-si-xiang-yu-fei-di-gui-xie-f/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

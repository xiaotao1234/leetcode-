package 其他;

/**
 * Created by Xiao Tao on 2020/2/12 21:13
 */
public class 最大整数加1 {
    public static void main(String[] args) {
        最大整数加1 s = new 最大整数加1();
        System.out.println(s.get());
        System.out.println(Integer.MIN_VALUE-1);
    }

    public int get(){
        return Integer.MAX_VALUE+1;
    }
}

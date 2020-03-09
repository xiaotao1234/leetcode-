package 递归练习;

/**
 * Created by Xiao Tao on 2020/2/20 9:56
 * 一只青蛙可以一次跳 1 级台阶或一次跳 2 级台阶,例如:
 * 跳上第 1 级台阶只有一种跳法：直接跳 1 级即可。跳上第 2 级台阶
 * 有两种跳法：每次跳 1 级，跳两次；或者一次跳 2 级。
 * 问要跳上第 n 级台阶有多少种跳法？
 */
public class 台阶问题 {
    public static void main(String[] args) {
        台阶问题 s1 = new 台阶问题();
        System.out.println(s1.get(10));
    }

    public int get(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return get(n-1)+get(n-2);
    }
}

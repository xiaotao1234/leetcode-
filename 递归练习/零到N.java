package 递归练习;

import 练习.最大子序和;

/**
 * Created by Xiao Tao on 2020/2/20 9:52
 */
public class 零到N {
    public static void main(String[] args) {
        零到N s1 = new 零到N();
        System.out.println(s1.get(10));
    }

    public int get(int n){
        if(n==1){
            return n;
        }
        return n*get(n-1);
    }
}

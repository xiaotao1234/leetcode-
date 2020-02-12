package 周赛171;

import 周赛170.解码字母到整数映射;

public class 将整数转换为两个无零整数的和 {
    public static void main(String[] args) {
        将整数转换为两个无零整数的和 s = new 将整数转换为两个无零整数的和();
        int m = s.getNoZeroIntegers(1010)[0];
        int n = s.getNoZeroIntegers(1010)[1];
        System.out.println(m+" "+n);
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 0; i < n; i++) {
            if(!iszero(i)&&!iszero(n-i)){
                return new int[]{i,n-i};
            }
        }
        return null;
    }

    public boolean iszero(int m) {
        String s = String.valueOf(m);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }
}

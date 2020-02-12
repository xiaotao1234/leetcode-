package 周赛172;

import 周赛171.将整数转换为两个无零整数的和;

/**
 * Created by Xiao Tao on 2020/1/19 11:12
 */
public class 组成的最大数字 {

    public static void main(String[] args) {
        组成的最大数字 s = new 组成的最大数字();
        System.out.println(s.maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)=='6'){
                 return Integer.parseInt(s.substring(0,i)+'9'+s.substring(i+1));
             }
        }
        return num;
    }
}

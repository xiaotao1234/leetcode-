package 周赛170;

import java.awt.*;

public class 解码字母到整数映射 {
    public static void main(String[] args) {
        解码字母到整数映射 s = new 解码字母到整数映射();
        System.out.println(s.freqAlphabets("313131113#"));
    }

    public String freqAlphabets(String s) {
        String s3 = "";
        for(int i = s.length()-1;i>=0;i--){
            if(String.valueOf(s.charAt(i)).equals("#")){
                i = i-2;
                String s1 = s.substring(i,i+2);
                char s2 = (char)(Integer.parseInt(s1)+96);
                s3 = s2+s3;
            }else {
                String s1 = s.substring(i,i+1);
                char s2 = (char)(Integer.parseInt(s1)+96);
                s3 = s2+s3;
            }
        }
        return s3;
    }
}

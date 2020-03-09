package 递归练习;

/**
 * Created by Xiao Tao on 2020/2/20 13:14
 */
public class 细胞分裂 {
    public static void main(String[] args) {
        细胞分裂 s1 = new 细胞分裂();
        System.out.println(s1.get(3,0,1,0,0));
    }

    public int get(int allhour, int hour, int first, int sencond, int third) {
        if (allhour == hour) {
            return first + sencond + third;
        }
        return get(allhour, hour + 1, first + sencond, first, sencond);
    }
}

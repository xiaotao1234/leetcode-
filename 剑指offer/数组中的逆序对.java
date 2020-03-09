package 剑指offer;

/**
 * Created by Xiao Tao on 2020/2/13 14:46
 */
public class 数组中的逆序对 {
    public static void main(String[] args) {
        数组中的逆序对 s = new 数组中的逆序对();
        System.out.println(s.reversePairs(new int[]{7,5,6,4,1}));
    }

    public int reversePairs(int[] nums) {
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    all++;
                }
            }
        }
        return all;
    }
}

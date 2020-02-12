package 动态规划或贪心;

/**
 * Created by Xiao Tao on 2020/2/5 16:09
 */
public class 台阶积水问题 {

    public static void main(String[] args) {
        台阶积水问题 s = new 台阶积水问题();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(s.get(nums,0,nums.length));
    }

    public int get(int[] nums,int start,int end) {
        if(end<start){
//            return
        }
        int i = getmax(start,end,nums);
        return get(nums,start,i-1)+get(nums,i+1,end);
    }

    public int getmax(int start, int end,int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxid = -1;
        for (int i = start; i < end; i++) {
            if(max<nums[i]){
                max = nums[i];
                maxid = i;
            }
        }
        return maxid;
    }
}

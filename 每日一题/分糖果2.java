package 每日一题;

/**
 * Created by Xiao Tao on 2020/3/5 8:36
 */
public class 分糖果2 {

    public static void main(String[] args) {
        分糖果2 s1 = new 分糖果2();
        System.out.println(s1.distributeCandies(10, 3));
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int j = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > 0) {
                    int should = j * num_people + i + 1;
                    if (candies > should) {
                        nums[i] = nums[i] + should;
                        candies = candies - should;
                    } else {
                        nums[i] = nums[i] + candies;
                        candies = 0;
                        break;
                    }
                }
            }
            j++;
        }
        return nums;
    }
}

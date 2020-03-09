package 各种排序方法;

/**
 * Created by Xiao Tao on 2020/2/26 9:20
 */
public class 冒泡排序 {//冒泡的基本思想是双重for循环遍历，对当前的元素和当前遍历的起始元素进行比较，根据情况进行调换，在双重循环结束后，数组也就有序了

    public static void main(String[] args) {
        冒泡排序 s = new 冒泡排序();
        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(s.sort(new int[]{2,4,7,1,5}));
    }

    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;
                }
            }
        }
        return nums;
    }
}

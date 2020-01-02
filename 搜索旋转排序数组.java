public class 搜索旋转排序数组 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //
    //你可以假设数组中不存在重复的元素。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        搜索旋转排序数组 s = new 搜索旋转排序数组();
        s.search(new int[]{4,5,6,7,0,1,2},0);
    }

    public int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        if(target>=nums[0]){
            int t = nums[0];
            for(int i = 0;i<nums.length;i++){
                if(nums[i]>=t){
                    if(target == nums[i]){
                        return i;
                    }
                }else {
                    return -1;
                }
                t = nums[i];
            }
        }else if(target<=nums[nums.length-1]){
            int t = nums[nums.length-1];
            for(int i = nums.length-1;i>0;i--){
                if(nums[i]<=t){
                    if(target == nums[i]){
                        return i;
                    }
                }else {
                    return -1;
                }
                t = nums[i];
            }
        }else{
            return -1;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        //解法二：时间复杂度要求lgN，因为其的一部分被翻转，那么我们在数据的中点位置进行切割为前后两段，那么总有前一段有序或后一段有序一定成立，
        //我们可以直接明确判断出这个target目标数如果在nums中存在的话，他在前一段还是后一段，我们找出了他在哪一段，然后再对子段进行中间位置切分，重复
        //关键点是利用在切分后，前后总有一段是有序的来排除一段，达到降低时间复杂度的目的
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }
}

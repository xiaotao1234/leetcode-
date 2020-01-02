import java.util.*;
//给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
//如果可以，请返回 True；否则，返回 False。
//示例 1：
//
//输入：nums = [1,2,3,3,4,4,5,6], k = 4
//输出：true
//解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 划分数组为连续数字的集合 {

    public static void main(String[] args) {
        划分数组为连续数字的集合 s = new 划分数组为连续数字的集合();
        System.out.println(s.isPossibleDivide1(new int[]{5,6,7,8,9,6,7,8,9,10,11,12,13,14,15,12,13,14,15,19}, 5));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        //解法一：使用PriorityQueue(优先队列)来作为核心数据结构，（主要利用了其的自动排序加队列的特性）
        //先将数组元素加入到优先队列（优先队列会自动排序），然后取队头元素（最下元素）
        //若然后去删除队头元+1大小的元素，删除成功则代表队列中存在这个元素（此时也就删除了这个元素），
        //失败则代表队列中不存在这个元素，则直接返回失败，待取队头元素取不到值时代表队列被取空，
        //返回true
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int m : nums) {
            priorityQueue.add(m);
        }
        while (priorityQueue.size() > 0) {
            int head = priorityQueue.poll();
            for (int i = 1; i < k; i++) {
                if (!priorityQueue.remove(head + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossibleDivide1(int[] nums, int k) {
        //解法二：使用Hash来作为核心数据结构（主要利用了其查找now+1的时间复杂度为1的特性，其巧妙的将数组元素作为key，该数组元素在数组中的数量作为value，有一个则为1，两个则为2）
        //然后将数组元素挨个插入到hash结构中，然后开始进行nums.length/k次的遍历，每次先取出现有的最小值start，然后依次查找是否在现有元素中有start+1，start+2..start+k-1,有任何一个元素找不到
        //直接返回false,否者返回false。
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> hash = new HashMap<>();
        for (int m : nums) {
            hash.put(m, hash.get(m)==null?1:hash.get(m) + 1);
        }
        for (int i = 0; i < nums.length / k; i++) {
            int index = 0;
            while (hash.get(nums[index]) == 0) {
                index++;
            }
            int start = nums[index];
            for (int j = 0; j < k; j++) {
                if(hash.get(start+j)==null||hash.get(start+j)==0){
                    return false;
                }
                hash.put(start+j,hash.get(start+j)-1);
            }
        }
        return true;
    }

    public int findNumbers(int[] nums) {
        int a = 0;
        for(int m:nums){
            if(String.valueOf(m).length()%2==0){
                a++;
            }
        }
        return a;
    }
}

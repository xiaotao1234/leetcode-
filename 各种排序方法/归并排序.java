package 各种排序方法;

/**
 * Created by Xiao Tao on 2020/2/13 15:20
 */
public class 归并排序 {//归并排序的主要思想是先归，即将当前集合分成更小的集合，当无法再分时，集合的元素数量变为了1，然后进行并，
    // 将当前两个子集合使用双指针法依据大小放入合并数组中，因此每个合并数组中的元素都是有序的，这为其作为后面并的子集创造了条件
    //在最终的归完成后，就完成了最终的排序，时间复杂度为NlgN，是一个稳定排序算法
    public static void main(String[] args) {
        归并排序 s = new 归并排序();
        System.out.println(s);
    }

    public void devide(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            devide(nums, start, middle);
            devide(nums, middle + 1, end);
            mergenum(nums, start, middle, end);
        }
    }

    public void mergenum(int[] nums, int left, int middle, int right) {
        int[] tem = new int[nums.length];
        int l = left;//待合并的组一的左指针
        int m = middle + 1;//待合并的组二的左指针
        int k = left;//辅助数组的起点
        while (l < middle && m < right) {//若待合并数组一和数组二都没有合并完毕
            if (nums[l] <= nums[m]) {//若数组一的当前指针所在数小于数组二的当前指针所在的数
                tem[k++] = nums[l++]; //将数组一的当前数赋值给辅助数组的对应位置，然后将数组一和辅助数组的位置都后移一位
            } else {
                tem[k++] = nums[m++];//同上
            }
        }
        while (l < middle) tem[k++] = nums[l++];//若数组二用完了而数组一未到末尾，则将数组一全加到辅助数组的末尾
        while (m < right) tem[k++] = nums[m++];//同上
        for (int i = left; i <= right; i++) {//将数组的对应位置的数改为辅助数组的对应位置的数，即将数组中的对应待合并段的数换成合并操作完成后的数组中的数
            nums[i] = tem[i];
        }
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = a[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

    public void mergeSort(int[] a, int start, int end) {
        if (start < end) {//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid + 1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

    public void devide1(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            devide1(nums, left, middle);
            devide1(nums, middle + 1, right);
            merge1(nums, left, right, middle);
        }
    }

    public void merge1(int[] nums, int left, int right, int middle) {
        int[] num = new int[nums.length];
        int l = left, r = middle + 1, s = left;
        while (l < middle && r < right) {
            if (nums[l] < nums[r]) num[s++] = nums[l++];
            else num[s++] = nums[r++];

        }
        while (l < middle) num[s++] = nums[l++];
        while (r < right) num[s++] = nums[r++];
        for (int i = left; i < right; i++) {
            nums[i] = num[i];
        }
    }


//————————————————
//    版权声明：本文为CSDN博主「睡着了才觉得冷」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/qq_36442947/article/details/81612870
}

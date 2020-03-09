package 各种排序方法;

/**
 * Created by Xiao Tao on 2020/2/26 9:25
 */
public class 快速排序 {//其基本思想是先选取一个基本值，如当前待排序序列的第一个元素，然后给其后边序列左右一个指针
    //左指针顺序找第一个比基本值大的数
    //右指针顺序找第一个比基本值小的数
    //找到后将两个数交换
    //然后继续找，直到最终左右指针相遇（此时的序列状态应该是待排序序列所有比基本值小的数都在比基本值大的左边）
    //且此时的左右指针重合的地方就是分界处，然后将基本值和分界处进行交换
    //然后再对分界左边和分界右边的子串分别重复上述操作直到右指针超过右指针

    /**
     * 快速排序
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void sort1(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int base = array[l];
        while (l < r) {

        }
    }

}































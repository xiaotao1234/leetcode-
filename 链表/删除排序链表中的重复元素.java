package 链表;

/**
 * Created by Xiao Tao on 2020/2/26 22:57
 */
public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headtmp = new ListNode(0);
        headtmp.next = head;
        while (head != null) {
            int m = head.val;
            while (head.next != null && head.next.val == m) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return headtmp.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {//递归解法
        if (head == null || head.next == null) {
            return head;
        }
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        head.next = deleteDuplicates1(head.next);
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

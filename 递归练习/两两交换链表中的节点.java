package 递归练习;

/**
 * Created by Xiao Tao on 2020/3/9 13:48
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        return dp(head);
    }

    public ListNode dp(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = head.next.next;
        ListNode listNode1 = head.next;
        head.next.next = head;
        head.next = dp(listNode);
        return listNode1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

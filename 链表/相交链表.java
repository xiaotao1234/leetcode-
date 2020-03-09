package 链表;

/**
 * Created by Xiao Tao on 2020/2/27 15:20
 */
public class 相交链表 {

    ListNode listNode1 = null;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        if (head1 == null || head2 == null) {
            return null;
        }
        while (head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null) {
            head1 = headB;
            while (head2 != null) {
                head1 = head1.next;
                head2 = head2.next;
            }
            head2 = headA;
            while (head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }
            return head1;
        }
        if (head2 == null) {
            head2 = headA;
            while (head1 != null) {
                head1 = head1.next;
                head2 = head2.next;
            }
            head1 = headB;
            while (head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }
            return head1;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

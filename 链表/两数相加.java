package 链表;

/**
 * Created by Xiao Tao on 2020/2/21 16:48
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加 {
    public static void main(String[] args) {
        两数相加 s1 = new 两数相加();
        System.out.println(s1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode l3 = new ListNode(0);
        ListNode header = l3;
        int jw = 0;
        while (l1 != null || l2 != null || jw != 0) {
            if (l1 != null && l2 != null) {
                int m = l1.val + l2.val + jw;
                if (m >= 10) {
                    jw = 1;
                } else {
                    jw = 0;
                }
                m = m % 10;
                l3.next = new ListNode(m);
                l1 = l1.next;
                l2 = l2.next;
                l3 = l3.next;
            } else if (l1 != null) {
                l3.next = new ListNode(l1.val);
                l3 = l3.next;
                jw = 0;
            } else if (l2 != null) {
                l3.next = new ListNode(l2.val);
                l3 = l3.next;
                jw = 0;
            } else {
                l3.next = new ListNode(jw);
                l3 = l3.next;
                jw = 0;
            }
        }
        return header.next;
    }

    public ListNode reverseList(ListNode head) {//解法一：递归解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

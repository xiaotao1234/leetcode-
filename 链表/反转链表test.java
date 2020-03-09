package 链表;

/**
 * Created by Xiao Tao on 2020/2/21 16:40
 */
public class 反转链表test {
    public static void main(String[] args) {
        反转链表test s1 = new 反转链表test();
        System.out.println(s1);
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

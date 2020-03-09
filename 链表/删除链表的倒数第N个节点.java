package 链表;

import 动态规划或贪心.猜数字大小2;

/**
 * Created by Xiao Tao on 2020/2/25 11:58
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        删除链表的倒数第N个节点 s = new 删除链表的倒数第N个节点();
        ListNode listNode = new ListNode(1);
        System.out.println(s.removeNthFromEnd(listNode, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        get(listNode,n);
        return listNode.next;
    }

    public int get(ListNode head, int n) {
        if (head == null) {
            return n;
        }
        int j = get(head.next, n);
        if (j == 0) {
            head.next = head.next.next;
            return -1;
        }else {
            return j-1;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

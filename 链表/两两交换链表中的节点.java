package 链表;

import 周赛177.形成三的最大倍数;

/**
 * Created by Xiao Tao on 2020/2/26 17:10
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        两两交换链表中的节点 s = new 两两交换链表中的节点();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(s.swap(listNode1));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode headrecoder = new ListNode(0);
        if (head.next != null) {
            headrecoder.next = head.next;
        } else {
            return head;
        }
        ListNode cur = head;
        ListNode hou = head.next;
        while (hou != null && cur != null && pre != null) {
            pre.next = cur;
            cur.next = hou.next;
            hou.next = cur;
            cur = cur.next;
            hou = cur.next;
        }
        return headrecoder.next;
    }

    public ListNode swap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode sencond = head.next;
        first.next = swap(sencond.next);
        sencond.next = first;
        return sencond;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

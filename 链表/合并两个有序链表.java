package 链表;

import 递归练习.第k个语法符号;

/**
 * Created by Xiao Tao on 2020/2/21 16:31
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        合并两个有序链表 s1 = new 合并两个有序链表();
        System.out.println(s1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode header = listNode;
        while (l1 != null || l2 != null) {
            if(l1==null){
                listNode.next = l2;
                listNode = l2;
                l2 = l2.next;
                continue;
            }
            if(l2==null){
                listNode.next = l1;
                listNode = l1;
                l1 = l1.next;
                continue;
            }
            if (l1.val >= l2.val) {
                listNode.next = l2;
                listNode = l2;
                l2 = l2.next;
            } else {
                listNode.next = l1;
                listNode = l1;
                l1 = l1.next;
            }
        }
        return header.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

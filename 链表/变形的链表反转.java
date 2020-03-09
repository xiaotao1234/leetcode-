package 链表;

/**
 * Created by Xiao Tao on 2020/2/26 11:10
 * 给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，
 * 并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。（不能使用队列或者栈作为辅助）
 */
public class 变形的链表反转 {
    public ListNode dx(ListNode listNode, int n) {
        if (listNode == null || listNode.next == null || n <= 0) {
            return listNode;
        }
        ListNode listNode1 = dx(listNode.next, n - 1);
        listNode.next.next = listNode;
        listNode.next = null;
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

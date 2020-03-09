package 链表;

/**
 * Created by Xiao Tao on 2020/2/18 15:09
 */
public class 反转链表 {
    public static void main(String[] args) {
        反转链表 s = new 反转链表();
        System.out.println(s);
    }

    public ListNode reverseList(ListNode head) {//双指针法
        ListNode pre = null;
        ListNode cur = head;
        ListNode tem;
        while (cur != null) {
            tem = cur.next;//记录当前节点的下一个节点
            cur.next = pre;//将当前节点的下一个节点指向上一个节点，
            pre = cur;//将两个指针都后移一位，前置节点指向当前节点
            cur = tem;//当前节点指向当前节点的后一个节点
        }
        return pre;
    }

    public ListNode dp(ListNode head) {//递归解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = dp(head.next);//取的已经翻转的子链表的头节点
        head.next.next = head;//在递归的回升时，将当前节点的下一个节点，即已经反转了的链表部分的尾部的下一个节点设为当前节点，即将当前的节点加入到反转
        head.next = null;//当前节点已经接入到翻转链表的尾部，将当前节点的next节点置为null，为接入下一个节点做准备
        return cur;//最终会返回翻转链表的头节点
    }//关键点在于递归回升时，未回升部分的节点为未逆序，回升的为逆序，因为未逆序，因此当前节点还可以找到下一个节点（依靠next指针，当逆序后其next指针就变为指向上一个节点了），我们对链表的逆序的操作是在
    //head.next.next = head;
    //将当前节点（未逆序的链表的最后一个节点）的下一个节点（已逆序链表的最后一个节点）的next指针指向当前节点，
    //也就是将当前节点即未逆序链表的最后一个节点加入到逆序链表中

    //递归解法的练习
    public ListNode dp1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = dp1(head.next);//当为遍历到尾指针时继续向下遍历
        head.next.next = head;//递归回升时进行指针逆转
        head.next = null;//在回升时，head总为当前正序链表的最后一个节点，
        return cur;//
    }

    public ListNode doublekill(ListNode listNode) {//双指针法的链表反转
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode tem;
        while (cur != null) {
            tem = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tem;
        }
        return pre;
    }

    public ListNode fanzhuan(ListNode head) {//反转练习
        if (head == null || head.next == null) {
            return head;
        }
        ListNode header = fanzhuan(head.next);
        head.next.next = head;
        head.next = null;
        return header;
    }

    public ListNode dg(ListNode listNode) {//递归解法的链表反转
        while (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode l = dg(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return l;
    }

    public ListNode lianxi(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode header = lianxi(head.next);
        head.next.next = head;
        head.next = null;
        return header;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

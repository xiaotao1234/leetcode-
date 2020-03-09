package 递归练习;

/**
 * Created by Xiao Tao on 2020/3/9 9:57
 */
public class 反转链表 {

    public static void main(String[] args) {
        反转链表 s1 = new 反转链表();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = listNode1;
        ListNode listNode5;
        listNode5 = listNode4;
        listNode2.next = listNode4;
        listNode4 = listNode3;
        System.out.println(listNode2.next.val);
        System.out.println(listNode5.val);
        System.out.println(listNode4.val);
    }

    public ListNode reverseList(ListNode head) {//递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public ListNode reverseList1(ListNode head) {//迭代---得出一个知识点，即两个引用之间进行赋值，是将前者指向了后者指向的那个实例对象，而后者的指向再次发生变化时，前者的指向不会跟着改变

        ListNode pre = null;
        ListNode next = head; // pre(null)  ->  next
        ListNode tem;
        while (next != null) {
            tem = next.next; // pre（null） ->  next  ->tem
            next.next = pre;  //  pre   <-  next   tem
            pre = next;//  pre  = next  tem
            next = tem;//
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

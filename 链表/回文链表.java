package 链表;

/**
 * Created by Xiao Tao on 2020/3/1 23:40
 */
public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        get(head,head);
        return yes;
    }

    boolean yes = true;

    public ListNode get(ListNode curent, ListNode pre) {
        if (curent == null || curent.next == null) {
            if (curent != null && curent.val == pre.val)
                return pre.next;
            else {
                yes = false;
                return null;
            }

        }
        ListNode listNode = get(curent.next, pre);
        if(listNode==null){
            return null;
        }
        if (listNode.val == curent.val) {
            return listNode.next;
        }else {
            yes = false;
            return null;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

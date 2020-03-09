package 链表;

/**
 * Created by Xiao Tao on 2020/2/27 14:07
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode listNodeM = head;//慢节点
        ListNode listNodeK = head.next;//快节点
        while (listNodeK != listNodeM) {//当当前两个节点未相遇时，即慢指针没能和快指针相遇时，（若为环则总会相遇，来跳出循环，则只要能跳出循环则为有环，为true）
            if (listNodeK == null || listNodeK.next == null) {//若有环，则两个节点永远也不会到尾部，若发现尾部，则代表无环
                return false;
            }
            listNodeK = listNodeK.next.next;//快节点进行移动
            listNodeM = listNodeM.next;//慢节点进行移动
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

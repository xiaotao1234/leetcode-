package 链表;

/**
 * Created by Xiao Tao on 2020/2/27 14:35
 * 找入环的第一个点
 * 首先假设为在环内的链表长度为a，环长度为b，
 * 设两个点相遇的位置距离入环的起点位置为c，
 * 则快慢两个指针第一次相遇时，慢指针走了a+c的长度，快指针走了a+b+c的长度
 * 且速度之比为2：1，即2（a+c） = a+b+c  ===》 a+c = b  ===>  a = b-c
 * 即两者第一次的相遇点距离入环点的顺指针距离为起点到入环点的距离，
 * 那么我们在快慢指针第一次相遇的这个点开始，将另一个指针又从起点开始两者都以慢指针的速度向下移动，两者相遇的点就是入环点
 */
public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode listNodeM = head;//慢节点
        ListNode listNodeK = head;//快节点
        if (head == null || head.next == null) {
            return null;
        }
        listNodeM = listNodeM.next;
        listNodeK = listNodeK.next.next;
        while (listNodeM != listNodeK) {
            if (listNodeK == null || listNodeK.next == null) {
                return null;
            }
            listNodeK = listNodeK.next.next;
            listNodeM = listNodeM.next;
        }
        listNodeK = head;
        while (listNodeK != listNodeM) {
            listNodeK = listNodeK.next;
            listNodeM = listNodeM.next;
        }
        return listNodeK;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package 链表;

/**
 * Created by Xiao Tao on 2020/2/27 9:01
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);//小于x的链表段的哑节点
        ListNode before = before_head;//指向哑节点的尾部的指针
        ListNode after_head = new ListNode(0);//大于x的链表段的哑节点
        ListNode after = after_head;//指向哑节点的尾部的指针
        while (head != null) {//当当前遍历到的节点不为空
            if (head.val < x) {//若当前节点值小于指定值
                before.next = head;//将当前节点加入以哑节点一为链表头的节点的尾部
                before = before.next;//将哑节点一为链表头的节点的尾部指针后移；
            } else {//若当前节点值大于指定值
                after.next = head;//将当前节点加入以哑节点二为链表头的节点的尾部；
                after = after.next;//将以哑节点二为链表头的节点的尾部指针后移
            }
            head = head.next;//将目标节点的当前节点的指针移动到当前节点的下一个节点
        }
        after.next = null;//将后链表的尾部节点置为空
        before.next = after_head.next;//将两段链表连接起来

        return before_head.next;//返回调整后的链表
    }

    public ListNode partitionPri(ListNode head, int x) {
        ListNode listNodeHeader1 = new ListNode(0);
        ListNode listNodeHeader2 = new ListNode(0);
        ListNode header1 = listNodeHeader1;
        ListNode header2 = listNodeHeader2;
        while (head != null) {
            if (head.val < x) {
                header1.next = head;
                header1 = header1.next;
            } else {
                header2.next = head;
                header2 = header2.next;
            }
            head = head.next;
        }
        header2.next = null;
        header1.next = listNodeHeader2.next;
        return listNodeHeader1.next;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

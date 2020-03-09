package 链表;

/**
 * Created by Xiao Tao on 2020/2/29 18:15
 */
public class 对链表进行插入排序 {

    public static void main(String[] args) {
        对链表进行插入排序 s = new 对链表进行插入排序();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(s.insertionSortList(listNode1));
    }


    public ListNode insertionSortList(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        int num = 0;
        while (head != null) {
            get(listNode.next, num++, listNode);
            head = head.next;
        }
        return listNode.next;
    }

    public ListNode get(ListNode node, int num, ListNode pre) {
        if (num <= 0) {
            pre.next = node.next;
            node.next = null;
            return node;
        }
        ListNode listNode = get(node.next, num - 1, node);
        if (listNode != null && node.val < listNode.val) {
            listNode.next = node.next;
            node.next = listNode;
            return null;
        } else {
            return node;
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

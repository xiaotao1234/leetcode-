package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiao Tao on 2020/2/26 23:20
 */
public class 删除排序链表中的重复元素2 {

    public static void main(String[] args) {
        删除排序链表中的重复元素2 s = new 删除排序链表中的重复元素2();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(s.deleteDuplicates3(listNode1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> record = new HashMap<>();
        ListNode headrecorder = new ListNode(0);
        headrecorder.next = head;
        record.put(head.val, 1);
        while (head.next != null) {
            while (record.containsKey(head.next.val)) {
                head.next = head.next.next;
            }
            record.put(head.val, 1);
            head = head.next;
        }
        return headrecorder.next;
    }

    Map<Integer, Integer> record = new HashMap<>();

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode header = new ListNode(Integer.MIN_VALUE);
        header.next = head;
        return dp(header).next;
    }

    public ListNode dp(ListNode head) {
        if (head == null) {
            return head;
        }
        if (record.containsKey(head.val)) {
            record.put(head.val, record.get(head.val) + 1);
            head = head.next;
        } else {
            record.put(head.val, 1);
        }
//        ListNode header =
        dp(head.next);
        if (head.next != null && record.get(head.next.val) > 1) {
            head.next = head.next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates3(head.next);
        } else {
            head.next = deleteDuplicates3(head.next);
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
        }
        return head;
    }

    public ListNode deleteDuplicates4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            return deleteDuplicates4(head.next);//在当前节点和后继节点值重复时，需要跳过当前节点
        } else {
            head.next = deleteDuplicates4(head.next);//在当前节点和后继节点不同时，其不在排除范围，将其加入处理后的后继节点链表后返回即可
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

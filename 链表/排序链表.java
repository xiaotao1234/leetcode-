package 链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Xiao Tao on 2020/2/25 14:44
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {//归并排序思想解题法
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;//靠慢指针来找到中点的下一个节点
        slow.next = null;//自中点将两段链表截断
        ListNode left = sortList(head);//获取前一段的有序
        ListNode right = sortList(tmp);//获取后一段的有序

        //将前/后有序进行合并为一个有序序列
        ListNode h = new ListNode(0);//设立合并链表的哨兵节点
        ListNode res = h;//记录哨兵节点
        while (left != null && right != null) {
            if (left.val < right.val) {//若前一段的当前值小于后一段
                h.next = left;//将前一段添加到合并链表的末尾
                left = left.next;//将前一段的当前值后移一位
            } else {
                h.next = right;//同上
                right = right.next;
            }
            h = h.next;//在合并链表添加一个节点后，将合并链表的当前节点后移一位
        }
        h.next = left != null ? left : right;//若左有序或右有序为全部加到合并链表的末尾，则将其未加入的全部加入
        return res.next;//返回合并链表
    }


    public ListNode sortListPratice(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tem = slow.next;
        slow.next = null;
        ListNode left = sortListPratice(head);
        ListNode right = sortListPratice(tem);//前段和后段分别有序
        ListNode listNode = new ListNode(0);//生成一个记录节点来作为合并后链表的存储
        ListNode res = listNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                listNode.next = left;
                left = left.next;
            } else {
                listNode.next = right;
                right = right.next;
            }
            listNode = listNode.next;
        }
        listNode.next = left == null ? right : left;
        return res.next;
    }


    public ListNode sortList1(ListNode head) {//先转为链表排序再在排序后重新生成链表的解法
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        return createLinkedList(list);
    }

    // list递归转链表
    private ListNode createLinkedList(List<Integer> data) {//递归版本的对list来生成对应的链表
        if (data.isEmpty()) {    //如果为空返回null
            return null;
        }
        ListNode firstNode = new ListNode(data.get(0));    //每次取第一个元素
        firstNode.next = createLinkedList(data.subList(1, data.size()));//第二个元素从下标为1开始取余下list
        return firstNode;
    }


    public ListNode sortList2(ListNode head) { //练习
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        return dp(list);
    }

    public ListNode dp(List<Integer> list) {//list转链表的递归解法
        if (list.size() == 0) {
            return null;
        }
        ListNode listNode = new ListNode(list.get(0));
        listNode.next = dp(list.subList(1, list.size()));
        return listNode;
    }

    public ListNode sortList3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dp1(list);
    }

    public ListNode dp1(List<Integer> list) {
        if (list.size() <= 0) {
            return null;
        }
        ListNode listNode = new ListNode(list.remove(0));
        listNode.next = dp1(list);
        return listNode;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

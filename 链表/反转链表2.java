package 链表;

/**
 * Created by Xiao Tao on 2020/2/18 16:45
 * 即局部逆转链表（m,n）
 * 解题的主要思想是：
 * 先递归到左边界n，然后就到达了当前函数递归的底部，然后开始进行待逆转区域的左逆转函数的递归，依靠这个函数实现待逆转函数的逆转
 * 在左逆转函数的递归完全返回时，返回的是逆转函数的头节点，当前的递归状态下拥有的信息包括当前节点，
 * 将当前节点和左逆转函数返回的头节点进行连接，然后当前节点也就变成了自当前节点往后节点的后续链表的头节点
 */
public class 反转链表2 {

    public static void main(String[] args) {
        反转链表2 s = new 反转链表2();
        System.out.println(s);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode record = new ListNode(0);

    ListNode listNode = new ListNode(0);

    public ListNode leftreserse(ListNode head, int left) {
        if (left == 1) {
            listNode = head.next;
            return head;
        }
        ListNode headerre = leftreserse(head.next, left - 1);
        head.next.next = head;
        head.next = listNode;
        return headerre;
    }

    public ListNode reserBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return leftreserse(head, n);
        }
        head.next = reserseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseLeftpp(ListNode listNode, int right) {
        if (right == 1) {//当到达左边界时
            record = listNode.next;//将当前需要逆转序列外右边的第一个节点记录下来，因为后面需要将逆转序列的右边接到这个节点上形成一个连续的链表
            return listNode;//返回当前节点（当前节点将作为逆转后链表的第一个节点）
        }
        ListNode h = reverseLeftpp(listNode.next, right - 1);
        listNode.next.next = listNode;//在上一个节点逆转完成返回后，将当前节点进行逆转，主要有两个操作，
        // 一：原链表在当前节点的下一个节点的next指针指向当前节点，完成当前节点的逆转
        listNode.next = record;// 二：将当前节点的next指针指向右边那一部分的未逆转链表，
        return h;//返回头节点
    }

    public ListNode reserseBetween(ListNode head, int left, int right) {
        if (left == 1) {//到达左边界结束本函数的递
            return reverseLeftpp(head, right);//将当前节点传给左边界逆转函数开始至当前到右边界的递归的流程
        }
        head.next = reserseBetween(head.next, left--, right--);//在最低层的归时，其做的事情是将左逆转函数的接在当前节点的后面，
        // （左逆转链表的尾部已经接到了右边的未逆转链表的头部）
        return head;//返回当前节点给上一节点。
    }

    public ListNode reverseBetweenPritce(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseLeft11(head, n);
        }
        head.next = reverseBetweenPritce(head.next, m - 1, n - 1);
        return head;
    }

    ListNode remeber = new ListNode(0);

    public ListNode reverseLeft11(ListNode head, int left) {
        if (left == 1) {
            remeber = head.next;
            return head;
        }
        ListNode listNode = reverseLeft11(head.next, left - 1);
        head.next.next = head;
        head.next = remeber;
        return listNode;
    }

    public ListNode reverseAll(ListNode head) {//反转整个单链表
        if (head != null || head.next != null) {
            return head;
        }
        ListNode cur = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    ListNode successor = null;

    public ListNode reverseLeft(ListNode head, int left) {
        if (left == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseLeft(head.next, left - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode leftl = null;

    public ListNode reverseArea(ListNode head, int left, int right) {
        if (left == 1) {
            leftl = head;
        }
        if (right == 1) {
            head.next = leftl;
            successor = head.next;
            return head;
        }
        ListNode last = reverseArea(head, left - 1, right - 1);
        if (head != leftl) {
            head.next.next = head;
            head.next = successor;
        }
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseLeft(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode dp(ListNode head) {//递归解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = dp(head.next);//取的已经翻转的子链表的头节点
        head.next.next = head;//在递归的回升时，将当前节点的下一个节点，即已经反转了的链表部分的尾部的下一个节点设为当前节点，即将当前的节点加入到反转
        head.next = null;//当前节点已经接入到翻转链表的尾部，将当前节点的next节点置为null，为接入下一个节点做准备
        return cur;//最终会返回翻转链表的头节点
    }
}

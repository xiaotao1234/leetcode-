public class 两数相加 {
    public static void main(String[] args) {
        两数相加 s = new 两数相加();
    }


    public ListNode addTwoNumbers12(ListNode l1, ListNode l2) {
        //这里的关键是head指针，我们也叫他预先指针，相当于用它来记录了链表的头节点，
        // 且这个头节点不会随着和他指向同一个实际元素节点的后移而移动，
        //其始终指向的是第一个节点，便于在后续输出这个节点
        ListNode head = new ListNode(0);
        ListNode current;
        current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int sun = x+y+carry;
            current.next = new ListNode(sun%10);
            current = current.next;
            carry = (sun)/10;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        return current.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public int get(ListNode l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

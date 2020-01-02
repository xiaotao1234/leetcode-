public class 旋转链表 {
    public static void main(String[] args) {
        旋转链表 s1 = new 旋转链表();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        System.out.println(s1.rotateRight(listNode, 1));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else if (k == 0) {
            return head;
        }
        ListNode cheader;
        ListNode newhead = null;
        cheader = head;
        int length = 0;
        while (cheader != null) {
            length++;
            cheader = cheader.next;
        }
        k = k % length;
        cheader = head;
        for (int i = 0; i <= k; i++) {
            if (i == k - 1) {
                newhead = cheader.next;
                cheader.next = null;
                cheader = newhead;
                while (cheader != null) {
                    cheader = cheader.next;
                }
                cheader.next = head;
            }
            cheader = cheader.next;
        }
        return newhead;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head.next == null)
            return head;
        if (head == null)
            return null;
        ListNode tdhead = head;
        int length = 0;
        while (tdhead.next != null) {
            tdhead = tdhead.next;
            length++;
        }
        tdhead.next = head;
        ListNode new_head;
        ListNode new_tail = head;
        for (int i = 0; i <= length - k % length-1;i++){
            new_tail = new_tail.next;
        }
        new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = "";
            ListNode listNode = this;
            while (listNode != null) {
                s = s + " " + listNode.val;
                listNode = listNode.next;
            }
            return s;
        }
    }
}

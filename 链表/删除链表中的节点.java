package 链表;

/**
 * Created by Xiao Tao on 2020/2/27 16:01
 * 要求删除链表中的一个节点，但是只给出了要删除的节点，没有其他信息
 * 这里的一般常识是，若我们要删除一个节点node,那么我们是先找到指向node的前置节点pre，令pre.next = pre.next.next来讲前置节点的指针指向当前节点的下一个节点，
 * 但是这里并不能找到前置节点
 * 所以采用一种讨巧的办法，先将下一个节点的值赋给当前节点，然后跳过下一个节点，这样一来，依靠赋值将当前节点的值覆盖，再通过跳过下一个节点来移除了多余的节点
 */
public class 删除链表中的节点 {
    public void deleteNode(ListNode node) {//
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

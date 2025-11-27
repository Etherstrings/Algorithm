package WorkReview.CralBook.LinkedListProblem;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-25
 */
public class L24CoupleChangeVal {
    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



    //输入：head = [1,2,3,4]
    //输出：[2,1,4,3]
    //示例 2：
    //
    //输入：head = []
    //输出：[]
    //示例 3：
    //
    //输入：head = [1]
    //输出：[1]

    public static void main(String[] args) {
        //1 2 3 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode res = swapPairs(head);
        System.out.println(res);
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode dum = new ListNode(-1, head);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = dum;
        ListNode n = dum.next;
        while (p.next!=null && p.next.next != null) {
            if (n == null || n.next == null) {
                break;
            }
            ListNode temp = n.next.next;
            p.next = n.next;
            p.next.next = n;
            n.next = temp;
            p = p.next.next;
            n = temp;
        }
        return dum.next;
    }
}

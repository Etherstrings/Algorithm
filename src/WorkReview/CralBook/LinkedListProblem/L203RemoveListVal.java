package WorkReview.CralBook.LinkedListProblem;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-19
 */
public class L203RemoveListVal {
    //给你一个链表的头节点 head 和一个整数 val ，
    // 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    public static void main(String[] args) {
        //输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
        //初始化一个head
        //    public ListNode(int val, ListNode next) {
        //        this.val = val;
        //        this.next = next;
        //    }
        ListNode head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        int val = 7;
        //调用removeElements方法
        head = removeElements(head, val);
        //遍历head
        while (head != null) {
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    /**
     * 卡了半天，是因为只有不等于val的时候，Pre节点本身才需要移动
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode Pre = dummy;
        ListNode Now = head;
        while (Now != null) {
            if (Now.val == val) {
                Pre.next = Now.next;
            } else {
                Pre = Now;
            }

            Now = Now.next;
        }
        return dummy.next;
    }


    public static ListNode getAnswer(ListNode head, int val) {
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode P = dum;
        ListNode N = dum.next;
        while (N != null) {
            if (N.val == val) {
                P.next = N.next;
            } else {
                P = N;
            }
            N = N.next;
        }
        return dum.next;
    }
}

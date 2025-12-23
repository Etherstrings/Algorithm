package WorkReview.CralBook.LinkedListProblem;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-27
 */
public class L19RemoveLastXNode {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(-1, head);
        ListNode p = dum;
        ListNode now = dum.next;
        for (int i = 0; i < n; i++)  {
            now = now.next;
        }
        while (now != null) {
            p = p.next;
            now = now.next;
        }
        p.next = p.next.next;
        return dum.next;
    }

    public static ListNode removeLastNNode(ListNode head, int n){
        ListNode Dum = new ListNode(-1,head);
        ListNode Pre = Dum;
        ListNode Now = head;
        for (int i=0;i<n;i++) {
            Now = Now.next;
        }
        while (Now!=null) {
            Now = Now.next;
            Pre = Pre.next;
        }
        Pre.next = Pre.next.next;
        return Dum.next;
    }
}

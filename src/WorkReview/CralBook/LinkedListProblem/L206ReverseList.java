package WorkReview.CralBook.LinkedListProblem;

/**
 * @author wuboyu <wuboyu@kuaishou.com>
 * Created on 2025-11-25
 */
public class L206ReverseList {
    //输入：head = [1,2] 输出：[2,1]
    public static void main(String[] args) {

    }
    public static ListNode getAnswer(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        if (now == null || now.next == null) {
            return head;
        }
        while (now!=null) {
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
        }
        return pre;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode Pre = null;
        ListNode Now = head;
        ListNode temp = null;
        if (head == null || head.next == null) {
            return head;
        }
        while (Now!=null) {
            temp = Now.next;
            Now.next = Pre;
            Pre = Now;
            Now = temp;
        }
        return Pre;
    }


}

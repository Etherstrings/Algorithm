package WorkReview.CralBook.LinkedListProblem;

public class L160TwoListHasSameNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dum = new ListNode(-1,headA);
        ListNode now = headA;
        ListNode nowb = headB;
        int sizeA = 0;
        while (now!=null) {
            sizeA++;
            now = now.next;
        }
        int sizeb = 0;
        now = headB;
        while (now!=null) {
            sizeb++;
            now = now.next;
        }
        if (sizeb > sizeA) {
            int gap = sizeb-sizeA;
            now = headA;
            for (int i=0;i<gap;i++) {
                nowb = nowb.next;
            }
            while (nowb!=null) {
                if (now == nowb) {
                    return now;
                }
                now = now.next;
                nowb= nowb.next;
            }
        } else {
            int gap = sizeA-sizeb;
            now = headA;
            for (int i=0;i<gap;i++) {
                now=now.next;
            }
            while (nowb!=null) {
                if (now == nowb) {
                    return now;
                }
                now = now.next;
                nowb= nowb.next;
            }
        }
        return null;
    }
}

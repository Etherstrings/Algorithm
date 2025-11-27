package TwoPoint;

import LinkedList.ListNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 15:55
 */
public class SII207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        int sizea=0;
        int sizeb=0;
        while(A!=null){
            A=A.next;
            sizea++;
        }
        while(B!=null){
            B=B.next;
            sizeb++;
        }
        return null;
    }
}

package src.TwoPoint;

import LinkedList.ListNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 15:38
 */
public class L206 {

    public ListNode reverseList(ListNode head) {
        //反转列表
        if(head==null){
            return head;
        }

        ListNode Pre=null;
        ListNode Now=head;
        while(Now!=null){
            ListNode Temp=Now.next;
            Now.next=Pre;
            Pre=Now;
            Now=Temp;
        }
        return Pre;
    }
}

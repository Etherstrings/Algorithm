package LinkedList;

/**
 * @author Justice_wby
 * @create 2023-01-16 3:06
 */
public class BM8 {
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(k==0){
            return null;
        }
        if(pHead==null){
            return null;
        }
        int len=0;
        ListNode P=pHead;
        while(P!=null){
            len++;
            P=P.next;
        }
        if(len<k){
            return null;
        }
        if(len==k){
            return pHead;
        }
        ListNode Dummy=new ListNode(-1);
        Dummy.next=pHead;
        ListNode Pre=Dummy;
        ListNode Now=Dummy.next;
        for(int i=0;i<k;i++){
            Now=Now.next;
        }
        while(Now!=null){
            Now=Now.next;
            Pre=Pre.next;
        }
        return Pre.next;
    }
}

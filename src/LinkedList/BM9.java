package LinkedList;

/**
 * @author Justice_wby
 * @create 2023-01-16 3:26
 */
public class BM9 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here

        if(n==0){
            return null;
        }
        if(head==null){
            return null;
        }
        int len=0;
        ListNode P=head;
        while(P!=null){
            len++;
            P=P.next;
        }
        if(len<n){
            return null;
        }
        if(len==n){
            return head.next;
        }
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;

        ListNode Pre=Dummy;
        ListNode Now=Dummy.next;
        for(int i=0;i<n;i++){
            Now=Now.next;
        }
        while(Now!=null){
            Now=Now.next;
            Pre=Pre.next;
        }
        Pre.next=Pre.next.next;
        return Dummy.next;
    }
}

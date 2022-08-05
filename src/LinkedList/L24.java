package LinkedList;

import java.util.List;

public class L24 {


    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode Dummy= new ListNode(-1,head);

        ListNode Pre=Dummy;
        ListNode Now=head;

        while(Pre.next != null && Pre.next.next != null){
            //保证了当前的下一个不是空值
            //当前的下一个的下一个也不是空值

            //-1  1 2 3 4
            //-1 2 1 4 3
            //存3
            ListNode temp = Now.next.next;
            //-1指向2
            Pre.next = Now.next;
            //2指向1
            Now.next.next = Now;
            //1指向4
            Now.next = temp;
            Pre = Now;
            Now = Now.next;

        }

        return Dummy.next;
    }
}

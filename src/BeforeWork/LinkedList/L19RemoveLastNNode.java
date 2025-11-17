package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-01-29 17:54
 */
public class L19RemoveLastNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {


        //双指针
            //核心思想是slow和fast相差了n个
                //while fast到end时
                    //slow为倒数第n个
       ListNode Notreally=new ListNode(-1,head);

       ListNode slow=Notreally;
       ListNode fast=Notreally;


       //fast先挪动n次
       for(int i=0;i<n;i++){
           fast=fast.next;
       }

        ListNode pre = null;
       //fast slow move
        while(fast!=null){
           pre=slow;
           slow=slow.next;
           fast=fast.next;
        }

        pre.next=slow.next;

       return Notreally.next;
    }
}

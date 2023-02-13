package LinkedList;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-05 16:24
 */
public class L142RoundTwo {
    public ListNode detectCycle(ListNode head) {
        //判断是否有环
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            //slow一次动一个
            //fast一次动两个
            slow=slow.next;
            fast=fast.next.next;


            if(slow==fast){
                //有环
                ListNode index1=head;
                ListNode index2=fast;

                //查找入口
                while(index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }

                return index1;
            }
            boolean f=true;
        }
        return null;
    }
}

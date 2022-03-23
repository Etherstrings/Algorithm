package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-01-29 16:30
 */
public class L24Two2Change {

    public ListNode swapPairs(ListNode head) {


        //定义虚拟头结点
        ListNode NotReally=new ListNode(-1,head);

        //根据循环条件
                //开始循环
        ListNode pre=NotReally;
        while(pre.next!=null&&pre.next.next!=null){
            //头指2
            pre.next=head.next;

            //存3
            ListNode temp=head.next.next;

            //3指向1
            head.next.next=head;

            //2指向老3
            head.next=temp;

            //指针变化
                //前序+1
                //当前也+1
            pre=head;
            head=head.next;


        }
        return NotReally.next;
    }
}

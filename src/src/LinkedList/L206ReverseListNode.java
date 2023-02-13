package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-01-25 22:02
 */
public class L206ReverseListNode {
    //206. 反转链表
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     *
     */
        //双指针改变
    public ListNode reverseList(ListNode head) {

        ListNode Pre=null;
        ListNode Now=head;
        ListNode Temp=null;
        while(Now!=null){
            //保存下个结点
            Temp=Now.next;
            //前边节点的数值 赋给Now.next
            Now.next=Pre;


            //移动前边的指针
            Pre=Now;
            //移动现在的指针
            Now=Temp;
        }
        return Pre;
    }


    public ListNode reverseList1(ListNode head) {
       return reserve(null,head);
    }
    //递归
    public ListNode reserve(ListNode pre,ListNode Now){
        if(Now==null){
            return pre;
        }
        ListNode Temp=null;
        //存下一个
        Temp=Now.next;
        //当前的指向前一个
        Now.next=pre;

        return reserve(Now,Temp);
    }

}

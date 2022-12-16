package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-01-20 16:53
 */
public class RemoveListNode {


    /**
     *
     * @param head
     * @param val
     * @return
     *
     * 203. 移除链表元素
     *     给你一个链表的头节点 head 和一个整数 val
     *     请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     *
     *
     */


    //虚拟结点----在head指针前 加一个虚拟的Node 随便赋值 指向head
    public LinkedList.ListNode removeElements(LinkedList.ListNode head, int val) {
        LinkedList.ListNode NotReally=new LinkedList.ListNode(-1,head);
        LinkedList.ListNode Pre=NotReally;
        LinkedList.ListNode Now=head;

        if(head==null){
            return head;
        }

        while(Now!=null){
            if(Now.val==val){
                Pre.next=Now.next;
            }else{
                Pre=Now;
            }
            Now=Now.next;
        }

        return NotReally.next;
    }


    //不用虚拟节点-----直接链表中修改
    public LinkedList.ListNode removeElements1(LinkedList.ListNode head, int val){
        //head为头结点 并不是头指针
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null){
            return head;
        }


        //此时 head.val!=val 了
        LinkedList.ListNode Pre=head;
        ListNode Now=head.next;

        while(Now!=null){
            if(Now.val==val){
                Pre.next=Now.next;
            }else{
                Pre=Now;
            }
            Now=Now.next;
        }
        return head;
    }
}

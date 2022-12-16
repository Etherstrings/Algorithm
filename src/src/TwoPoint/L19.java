package src.TwoPoint;

import LinkedList.ListNode;

/**
 * @description:
 * @author： wuboyu
 * @date： 2022-08-09 15:43
 */
public class L19 {
    //19. 删除链表的倒数第 N 个结点
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //示例 2：
    //
    //输入：head = [1], n = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [1,2], n = 1
    //输出：[1]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //倒数第N个节点
        ListNode Slow=head;
        ListNode Fast=head;
        ListNode Dummy=new ListNode(-1,head);
        ListNode Pre=Dummy;
        for(int i=0;i<n;i++){
            Fast=Fast.next;
        }
        while(Fast!=null){
            Fast=Fast.next;
            Pre=Pre.next;
        }

        Pre.next=Pre.next.next;
        return Dummy.next;
    }
}

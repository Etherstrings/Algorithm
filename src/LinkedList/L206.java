package LinkedList;

import javax.swing.*;

public class L206 {
    //206. 反转链表
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5]
    //输出：[5,4,3,2,1]
    //示例 2：
    //
    //
    //输入：head = [1,2]
    //输出：[2,1]
    //示例 3：
    //
    //输入：head = []
    //输出：[]
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        //设置当前遍历节点Now
        //设置前遍历节点Pre
        ListNode Now=head;
        ListNode Pre=null;

        while(Now!=null){
            //当前遍历节点不是Null
            ListNode Temp=Now.next;
            Now.next=Pre;
            Pre=Now;
            Now=Temp;
        }
        return Pre;
    }

}

package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-02-03 18:21
 */
public class J02027 {
    /**
     *  面试题 02.07. 链表相交
     * @param headA
     * @param headB
     * @return
     */


    /**
     *
     *
     * @param headA
     * @param headB
     * @return
     *
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
     * 如果两个链表没有交点，返回 null 。
     *
     * 图示两个链表在节点 c1 开始相交：
     *
     *
     *
     * 题目数据 保证 整个链式结构中不存在环。
     *
     * 注意，函数返回结果后，链表必须 保持其原始结构
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A=headA;
            ListNode B=headB;


            int lenA=0;int lenB=0;

            while(A!=null){
                lenA++;
                A=A.next;
            }

            while(B!=null){
                lenB++;
                B=B.next;
            }

            A=headA;
            B=headB;
            if(lenB>lenA){
                int temlen=lenA;
                lenA=lenB;
                lenB=temlen;

                ListNode temNode=A;
                A=B;
                B=temNode;
            }


            int gap=lenA-lenB;

            while(gap-->0){
                A=A.next;
            }

            while(A!=null){
                if(A==B){
                    return A;
                }
                A=A.next;
                B=B.next;
            }
            return null;
    }
}

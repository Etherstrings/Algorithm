package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-08-08 0:15 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  TwoLinkedListCross - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/8 - the current system date.  0:15 - the current system time.  2022 - the current year.  08 - the current month.  08 - the current day of the month.  00 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class TwoLinkedListCross {
    //面试题 02.07. 链表相交
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    //
    //图示两个链表在节点 c1 开始相交：
    //
    //
    //
    //题目数据 保证 整个链式结构中不存在环。
    //
    //注意，函数返回结果后，链表必须 保持其原始结构 。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    //输出：Intersected at '8'
    //解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
    //从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
    //在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
    //示例 2：
    //
    //
    //
    //输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    //输出：Intersected at '2'
    //解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
    //从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
    //在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
    //示例 3：
    //
    //
    //
    //输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    //输出：null
    //解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
    //由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
    //这两个链表不相交，因此返回 null 。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //核心是什么？

        //核心就是两者一旦相交---就存在共同的部分

        //只要先把末尾对齐
        //剩下的只要相同 就是有交点
        ListNode Now=headA;
        int sizea=0;
        while(Now!=null){
            sizea++;
            Now=Now.next;
        }

        Now=headB;
        int sizeb=0;
        while(Now!=null){
            sizeb++;
            Now=Now.next;
        }

        if(sizea>sizeb){
            int n=sizea-sizeb;
            ListNode a=headA;
            ListNode b=headB;
            for(int i=0;i<n;i++){
                a=a.next;
            }
            while(a!=null){
                if(a==b){
                    return a;
                }
                a=a.next;
                b=b.next;
            }
        }else if(sizea<sizeb){
            int n=sizeb-sizea;
            ListNode a=headA;
            ListNode b=headB;
            for(int i=0;i<n;i++){
                b=b.next;
            }
            while(b!=null){
                if(a==b){
                    return b;
                }
                a=a.next;
                b=b.next;
            }
        }else {
            ListNode a=headA;
            ListNode b=headB;
            while(b!=null){
                if(a==b){
                    return b;
                }
                a=a.next;
                b=b.next;
            }
        }
        return null;
    }
}

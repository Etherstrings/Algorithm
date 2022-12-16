package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-08-13 18:40 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L143 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/13 - the current system date.  18:40 - the current system time.  2022 - the current year.  08 - the current month.  13 - the current day of the month.  18 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L143 {
    //143. 重排链表
    //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
    //
    //L0 → L1 → … → Ln - 1 → Ln
    //请将其重新排列后变为：
    //
    //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    //不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：head = [1,2,3,4]
    //输出：[1,4,2,3]
    //示例 2：
    //
    //
    //
    //输入：head = [1,2,3,4,5]
    //输出：[1,5,2,4,3]
    public void reorderList(ListNode head) {
        //head不变
        //从末尾排序到head.next
        ListNode Dummy=null;
        ListNode Pre=Dummy;
        ListNode Now=head;
        while(Now!=null){
            ListNode Temp=Now.next;
            Now.next=Pre;
            Pre=Now;
            Now=Temp;
        }

    }
}

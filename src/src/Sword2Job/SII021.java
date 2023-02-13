package src.Sword2Job;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-04-11 20:38 Sword2Job - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  SII021 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/4/11 - the current system date.  20:38 - the current system time.  2022 - the current year.  04 - the current month.  11 - the current day of the month.  20 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class SII021 {
    //剑指 Offer II 021. 删除链表的倒数第 n 个结点
    //给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode Notrel=new ListNode(-1);
        Notrel.next=head;

        ListNode fast=head;
        ListNode Now=Notrel;

        while(fast!=null&&n>0){
            fast=fast.next;
            n--;
        }

        while(fast!=null){
            Now=Now.next;

            fast=fast.next;
        }
        Now.next=Now.next.next;
        return Notrel.next;

    }
}

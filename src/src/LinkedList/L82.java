package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-08-06 19:18 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L82 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/6 - the current system date.  19:18 - the current system time.  2022 - the current year.  08 - the current month.  06 - the current day of the month.  19 - the current hour.  18 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L82 {
    //82. 删除排序链表中的重复元素 II
    //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,3,4,4,5]
    //输出：[1,2,5]
    //示例 2：
    //
    //
    //输入：head = [1,1,1,2,3]
    //输出：[2,3]
    public ListNode deleteDuplicates(ListNode head) {
        //这个是有重复直接删了
        ListNode Dummy=new ListNode(-101,head);
        ListNode Pre=Dummy;
        ListNode now=head;

        if(head==null){
            return null;
        }
        while(now!=null&&now.next!=null){
            if(now.val==now.next.val){
                //这俩都需要删掉
                int val=now.val;
                while(now!=null&&now.val==val){
                    now=now.next;
                }
                Pre.next=now;
            }else {
                Pre=now;
                now=now.next;
            }
        }
        return Dummy.next;

    }

    public ListNode deleteDuplicates1(ListNode head) {
        //这个是去重
        ListNode Dummy = new ListNode(-101, head);

        ListNode slow = Dummy;
        ListNode fast = head;
        ListNode pre = Dummy;

        while (fast != null) {
            if (fast.val == slow.val) {
                pre.next = fast.next;
                pre = fast;
                fast = fast.next;
            } else {
                pre = fast;
                fast = fast.next;
                slow = slow.next;
            }


        }
        return Dummy.next;
    }
}

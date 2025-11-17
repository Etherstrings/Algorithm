package LinkedList;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-08-08 0:01 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L19 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/8 - the current system date.  0:01 - the current system time.  2022 - the current year.  08 - the current month.  08 - the current day of the month.  00 - the current hour.  01 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
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
        //核心是想到
        //怎么标记倒数第n个节点

        //两个指针a b  b先走n
        //当b到了末尾 那么a的位置就是倒数第n个节点

        // 1 2 3 4 5

        ListNode Dummy=new ListNode(-1,head);
        ListNode Slow=head;
        ListNode Fast=head;
        ListNode Pre=Dummy;

        for(int i=0;i<n;i++){
            Fast=Fast.next;
        }

        while(Fast!=null){
            Fast=Fast.next;
            Pre=Slow;
            Slow=Slow.next;
        }

        Pre.next=Slow.next;
        return Dummy.next;

    }
}

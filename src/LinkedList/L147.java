package LinkedList;

import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-06-15 23:02 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L147 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/15 - the current system date.  23:02 - the current system time.  2022 - the current year.  06 - the current month.  15 - the current day of the month.  23 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L147 {
    //147. 对链表进行插入排序
    //给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
    //
    //插入排序 算法的步骤:
    //
    //插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    //每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    //重复直到所有输入数据插入完为止。
    //下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
    //
    //对链表进行插入排序。


    //思路

    //1. 遍历 head
    //2. 挨个插入 每次插入的时候排序
    public ListNode insertionSortList(ListNode head) {
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;
        ListNode now=Dummy.next;

        ListNode newHead=new ListNode();
        while(now!=null){
            insert(head,now);
            now=now.next;
        }

        return Dummy.next;
    }

    ListNode insert(ListNode head,ListNode Pot){
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;
        if(head==null){
            return Pot;
        }
        if(head.next==null){
            if(head.val>=Pot.val){
                head.next=Pot;
                return head;
            }else {
                Dummy.next=Pot;
                Pot.next=head;
                head.next=null;
                return Dummy.next;
            }
        }
    }


}

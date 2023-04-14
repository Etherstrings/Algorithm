package LinkedList;

/**
 * @author Etherstrings
 * @create 2023-04-01 14:44 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L24 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/1 - the current system date.  14:44 - the current system time.  2023 - the current year.  04 - the current month.  01 - the current day of the month.  14 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode Dummy= new ListNode(-1,head);

        ListNode Pre=Dummy;
        ListNode Now=head;

        while(Pre.next != null && Pre.next.next != null){
            //保证了当前的下一个不是空值
            //当前的下一个的下一个也不是空值

            //-1  1 2 3 4
            //-1 2 1 4 3
            //存3
            ListNode temp = Now.next.next;
            //-1指向2
            Pre.next = Now.next;
            //2指向1
            Now.next.next = Now;
            //1指向4
            Now.next = temp;
            Pre = Now;
            Now = Now.next;

        }

        return Dummy.next;
    }
}

package LinkedList;

/**
 * @author Etherstrings
 * @create 2023-04-01 14:36 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L206 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/4/1 - the current system date.  14:36 - the current system time.  2023 - the current year.  04 - the current month.  01 - the current day of the month.  14 - the current hour.  36 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  4月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  四月 - full name of a month. Example: January, February, etc
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode Dum=null;
        ListNode Pre=Dum;
        ListNode Now=head;
        while(Now!=null){
            ListNode Temp=Now.next;
            Now.next=Pre;
            Pre=Now;
            Now=Temp;
        }
        return Pre;
    }
}

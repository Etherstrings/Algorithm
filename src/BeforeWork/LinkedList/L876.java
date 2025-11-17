package LinkedList;

/**
 * @author Etherstrings
 * @create 2023-02-24 16:44 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L876 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/24 - the current system date.  16:44 - the current system time.  2023 - the current year.  02 - the current month.  24 - the current day of the month.  16 - the current hour.  44 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L876 {

    public ListNode middleNode(ListNode head) {
        ListNode Dummy=new ListNode(-1,head);
        ListNode Pre=Dummy;
        ListNode Now=head;
        int size=0;
        while(Now!=null){
            size++;
            Now=Now.next;
        }
        size=size/2;

        Now=head;
        for(int i=0;i<size;i++){
            Now=Now.next;
        }

        return Now;
    }
}

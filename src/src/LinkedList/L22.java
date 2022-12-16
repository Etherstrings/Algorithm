package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-03-10 10:57 LinkedList - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L22 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/10 - the current system date.  10:57 - the current system time.  2022 - the current year.  03 - the current month.  10 - the current day of the month.  10 - the current hour.  57 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L22 {
    public LinkedList.ListNode getKthFromEnd(LinkedList.ListNode head, int k) {
    LinkedList.ListNode fast=head;
    ListNode slow=head;
    while(fast!=null&&k>0){
        fast=fast.next;
        k--;
    }
    while(fast!=null){
        slow=slow.next;
        fast=fast.next;
    }

    return slow;
    }
}

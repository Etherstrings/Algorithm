package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-03-17 19:38 LinkedList - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  null.java - the name of the PHP file that will be created.  J52 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/17 - the current system date.  19:38 - the current system time.  2022 - the current year.  03 - the current month.  17 - the current day of the month.  19 - the current hour.  38 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class J52 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }

        ListNode A=headA;
        ListNode B=headB;

        while(A!=B){
            A=A==null?headB:A.next;
            B=B==null?headA:B.next;
        }
        return A;
    }

}

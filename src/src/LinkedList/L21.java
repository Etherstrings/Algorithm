package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-06-07 16:59 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L21 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/7 - the current system date.  16:59 - the current system time.  2022 - the current year.  06 - the current month.  07 - the current day of the month.  16 - the current hour.  59 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L21 {
    public LinkedList.ListNode mergeTwoLists(LinkedList.ListNode list1, LinkedList.ListNode list2) {


        LinkedList.ListNode Now1=list1;
        LinkedList.ListNode Now2=list2;

        LinkedList.ListNode PreAnswer=new LinkedList.ListNode(-1);
        ListNode Cur=PreAnswer;

        while(Now1!=null&&Now2!=null){
            if(Now1.val<Now2.val){
                Cur.next=Now1;
                Cur=Cur.next;

                Now1=Now1.next;
            }else {

                Cur.next=Now2;
                Cur=Cur.next;
                Now2=Now2.next;
            }
        }
        if(Now1==null){
            Cur.next=Now2;
        }else {
            Cur.next=Now1;
        }
        return PreAnswer.next;

    }
}

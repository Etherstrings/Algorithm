package src.LinkedList;

/**
 * @author Etherstrings
 * @create 2022-03-10 10:29 LinkedList - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L18 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/10 - the current system date.  10:29 - the current system time.  2022 - the current year.  03 - the current month.  10 - the current day of the month.  10 - the current hour.  29 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */

import LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class L18 {


    public ListNode deleteNode(ListNode head, int val) {

        if(head.val==val){
            return head.next;
        }
        ListNode now=head.next;
        ListNode pre=head;
        while(now!=null&&now.val!=val){
            pre=now;
            now=now.next;
        }

        if(now!=null){
            pre.next=now.next;
        }

        return head;
    }
}



package Niuke;

import LinkedList.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Etherstrings
 * @create 2023-07-27 20:08 Niuke - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  NB11_Youxian - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/27 - the current system date.  20:08 - the current system time.  2023 - the current year.  07 - the current month.  27 - the current day of the month.  20 - the current hour.  08 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class NB11_Youxian {
    public ListNode mergeKLists (ListNode[] lists) {
        // write code here
        Queue<Integer> small = new PriorityQueue<>((x, y) -> (x - y));
        for(ListNode now:lists){
            while(now!=null){
                small.add(now.val);
                now=now.next;
            }
        }
        ListNode Dummy=new ListNode(-1,null);
        ListNode Index=Dummy;
        while(!small.isEmpty()){
            ListNode temp=new ListNode(small.poll(),null);
            Index.next=temp;
            Index=Index.next;
        }
        return Dummy.next;
    }
}

package src.LinkedList;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-13 16:41 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BM5 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/13 - the current system date.  16:41 - the current system time.  2022 - the current year.  11 - the current month.  13 - the current day of the month.  16 - the current hour.  41 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class BM5 {
    public LinkedList.ListNode mergeKLists(ArrayList<LinkedList.ListNode> lists) {
        List<Integer> ans=new ArrayList<>();
        for(LinkedList.ListNode head:lists){
            if(head==null){
                continue;
            }
            LinkedList.ListNode now=head;
            while(now!=null){
                ans.add(now.val);
                now=now.next;
            }
        }

        if(ans.size()==0){
            return null;
        }
        Collections.sort(ans);
        return arrayToListNode1(ans);
    }

    static LinkedList.ListNode arrayToListNode1(List<Integer> s){
        LinkedList.ListNode root=new LinkedList.ListNode(s.get(0));
        LinkedList.ListNode other=root;
        for(int i=1;i<s.size();i++){
            LinkedList.ListNode temp=new ListNode(s.get(i));
            other.next=temp;
            other=temp;
        }
        return root;
    }
}

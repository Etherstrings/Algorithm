package LinkedList;

import java.util.*;

import static Tool.ATool.Array2LinkedList;
import static Tool.ATool.LinkedList2ArrayList;

/**
 * @author Etherstrings
 * @create 2023-02-27 13:31 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L83 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/2/27 - the current system date.  13:31 - the current system time.  2023 - the current year.  02 - the current month.  27 - the current day of the month.  13 - the current hour.  31 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  2月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> n=LinkedList2ArrayList(head);
        Set<Integer> temp=new HashSet<>();
        for(int now:n){
            temp.add(now);
        }
        n=new ArrayList<>();
        for(int now:temp){
            n.add(now);
        }
        Collections.sort(n);
        return Array2LinkedList(null,n);
    }
}

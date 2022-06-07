package LinkedList;

import java.util.*;

/**
 * @author Etherstrings
 * @create 2022-06-07 17:16 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L141 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/7 - the current system date.  17:16 - the current system time.  2022 - the current year.  06 - the current month.  07 - the current day of the month.  17 - the current hour.  16 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> Judege=new HashSet<>();

        //当前遍历节点
        ListNode Now=head;
        while(Now!=null){
            if(Judege.add(Now)){
                //说明成功添加了
                //没有重复的
            }else {
                return true;
            }
            Now=Now.next;
        }
        return false;
    }
}

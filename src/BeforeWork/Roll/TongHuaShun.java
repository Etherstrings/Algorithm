package Roll;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-03-10 13:52 Roll - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  TongHuaShun - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/3/10 - the current system date.  13:52 - the current system time.  2023 - the current year.  03 - the current month.  10 - the current day of the month.  13 - the current hour.  52 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  3月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class TongHuaShun {
    public static List<Integer> getans(int round){
        ListNode head=new ListNode(1,null);
        ListNode now=head;
        for(int i=1;i<=64;i++){
            if(i==1){
                head=new ListNode(i,null);
                now=head;
                continue;
            }
            now.next=new ListNode(i,null);
            now=now.next;
        }
        int size=64;
        for(int i=0;i<round;i++){
            if(size<5){
                break;
            }
            ListNode Dumy=new ListNode(-1,head);
            ListNode Pre=Dumy;
            now=head;
            int times=0;
            while(now!=null){
                times++;
                if(times%5==0){
                    Pre.next=now.next;
                    size--;
                }
                now=now.next;
                Pre=Pre.next;
            }
        }
        List<Integer> ans=new ArrayList<>();
        now=head;
        while(now!=null){
            ans.add(now.val);
            now=now.next;
        }
        return ans;
    }
}

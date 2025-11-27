package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-12 12:15 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BM2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/12 - the current system date.  12:15 - the current system time.  2022 - the current year.  11 - the current month.  12 - the current day of the month.  12 - the current hour.  15 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class BM2 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        List<Integer> list=new ArrayList<>();
        ListNode now=head;
        while(now!=null){
            list.add(now.val);
            now=now.next;
        }
        // m=2
        // n=4
        // 1 2 3 4 5 6
        // 0 1 2 3 4 5
        // 2-4
        // 1-3
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<m-1;i++){
            temp.add(list.get(i));
        }
        for(int i=n-1;i>=m-1;i--){
            temp.add(list.get(i));
        }
        for(int i=n;i<list.size();i++){
            temp.add(list.get(i));
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=temp.get(i);
        }
        return arrayToListNode(ans);
    }

    static ListNode arrayToListNode(int[] s){
        ListNode root=new ListNode(s[0]);
        ListNode other=root;
        for(int i=1;i<s.length;i++){
            ListNode temp=new ListNode(s[i]);
            other.next=temp;
            other=temp;
        }
        return root;
    }
}

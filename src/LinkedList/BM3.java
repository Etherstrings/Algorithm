package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-11-12 13:56 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  BM3 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/11/12 - the current system date.  13:56 - the current system time.  2022 - the current year.  11 - the current month.  12 - the current day of the month.  13 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  11月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  十一月 - full name of a month. Example: January, February, etc
 */
public class BM3 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        List<Integer> temp=new ArrayList<>();
        ListNode now=head;
        if(head==null){
            return null;
        }
        while(now!=null){
            temp.add(now.val);
            now=now.next;
        }
        if(temp.size()<k){
            //不反转
            return head;
        }
        if(temp.size()==k){
            //翻转链表
            Collections.reverse(temp);
            return arrayToListNode1(temp);
        }
        int round=temp.size()/k;
        int left=temp.size()%k;
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=round;i++){
            //0 1  i=1
            //2 3  i=2
            int start=i*k-1;
            int end=(i-1)*k;
            for(int j=start;j>=end;j--){
                ans.add(temp.get(j));
            }
        }
        //加上最后的几个
        for(int i=round*k;i<temp.size();i++){
            ans.add(temp.get(i));
        }
        return arrayToListNode1(ans);
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

    static ListNode arrayToListNode1(List<Integer> s){
        ListNode root=new ListNode(s.get(0));
        ListNode other=root;
        for(int i=1;i<s.size();i++){
            ListNode temp=new ListNode(s.get(i));
            other.next=temp;
            other=temp;
        }
        return root;
    }
}

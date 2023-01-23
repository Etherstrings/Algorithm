package LinkedList;

import Tool.ATool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-21 19:32
 */
public class BM11 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        StringBuffer num1=new StringBuffer();
        ListNode now=head1;
        while(now!=null){
            num1.append(now.val);
            now=now.next;
        }
        StringBuffer num2=new StringBuffer();
        now=head2;
        while(now!=null){
            num2.append(now.val);
            now=now.next;
        }
        char[] temp=(Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString())+"").toCharArray();
        List<Integer> list=new ArrayList<>();
        for(char n:temp){
            list.add((n-'0'));
        }
        return ATool.Array2LinkedList(null,list);
    }

}

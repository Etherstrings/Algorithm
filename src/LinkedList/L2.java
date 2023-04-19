package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2022-02-18 10:03 LinkedList - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L2 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/2/18 - the current system date.  10:03 - the current system time.  2022 - the current year.  02 - the current month.  18 - the current day of the month.  10 - the current hour.  03 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  二月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  二月 - full name of a month. Example: January, February, etc
 */
public class L2 {
    //2. 两数相加
    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1;
        int v2;
        if(l1.val==0&&l2.val==0){
            v1=0;
            v2=0;
            return new ListNode(0,null);
        }else if(l1.val==0){
            v1=0;
            return reverseList(l2);
        }else if(l2.val==0){
            return reverseList(l1);
        }else {
            l1=reverseList(l1);
            l2=reverseList(l2);
            String num1="";
            String num2="";
            ListNode now=l1;
            while(now!=null){
                num1+=now.val;
                now=now.next;
            }
            now=l2;
            while (now!=null){
                num2+=now.val;
                now=now.next;
            }
            int ans=Integer.parseInt(num1)+Integer.parseInt(num2);
            String ss=ans+"";
            int[] s=new int[ss.length()];
            for(int i=0;i<ss.length();i++){
                s[i]=Integer.parseInt(ss.charAt(i)+"");
            }
            return reverseList(arrayToListNode(s));
        }


    }

    public static ListNode reverseList(ListNode head) {

        ListNode Pre=null;
        ListNode Now=head;
        ListNode Temp=null;
        while(Now!=null){
            //保存下个结点
            Temp=Now.next;
            //前边节点的数值 赋给Now.next
            Now.next=Pre;


            //移动前边的指针
            Pre=Now;
            //移动现在的指针
            Now=Temp;
        }
        return Pre;
    }

    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1.val==0&&head2.val==0){
            return new ListNode(0,null);
        }else if(head1.val==0){
            return reverseList(head2);
        }else if(head2.val==0){
            return reverseList(head1);
        }else {
            String num1="";
            String num2="";
            ListNode now=head1;
            while(now!=null){
                num1+=now.val;
                now=now.next;
            }
            now=head2;
            while (now!=null){
                num2+=now.val;
                now=now.next;
            }
            int ans=Integer.parseInt(num1)+Integer.parseInt(num2);
            String ss=ans+"";
            int[] s=new int[ss.length()];
            for(int i=0;i<ss.length();i++){
                s[i]=Integer.parseInt(ss.charAt(i)+"");
            }
            return arrayToListNode(s);
        }
    }
}

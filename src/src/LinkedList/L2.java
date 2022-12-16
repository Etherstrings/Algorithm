package src.LinkedList;

import LinkedList.ListNode;

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



        //这个思路是错的
        //翻转l1 l2
        reverseList(l1);
        reverseList(l2);

        String a="";
        String b="";
        ListNode Pointa=l1;
        ListNode Pointb=l2;
        while(Pointa!=null){
            a+=Pointa.val;
            Pointa=Pointa.next;
        }
        while(Pointb!=null){
            b+=Pointb.val;
            Pointb=Pointb.next;
        }
        Integer anew = Integer.valueOf(a);
        Integer bnew=Integer.valueOf(b);
        int sum=anew+bnew;



    }

    public ListNode reverseList(ListNode head) {

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
}

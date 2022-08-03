package LinkedList;

/**
 * @author Etherstrings
 * @create 2022-08-03 23:40 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L203 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/8/3 - the current system date.  23:40 - the current system time.  2022 - the current year.  08 - the current month.  03 - the current day of the month.  23 - the current hour.  40 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  8月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  八月 - full name of a month. Example: January, February, etc
 */
public class L203 {
    //203. 移除链表元素
    //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,6,3,4,5,6], val = 6
    //输出：[1,2,3,4,5]
    //示例 2：
    //
    //输入：head = [], val = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [7,7,7,7], val = 7
    //输出：[]
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return new ListNode();
        }
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;

        ListNode Pre=Dummy;
        ListNode Now=head;

        while(Now!=null){
            if(Now.val==val){
                //当前是需要删除的点
                Pre.next=Now.next;
            }else {
                Pre=Now;
            }
            Now=Now.next;
        }
        return Dummy.next;
    }
}

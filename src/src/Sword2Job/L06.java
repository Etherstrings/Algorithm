package src.Sword2Job;







import java.util.Stack;

/**
 * @author Etherstrings
 * @create 2022-03-08 11:02 Sword2Job - the name of the target package where the new class or interface will be created.  ideaworkplace - the name of the current project.  ${FILE_NAME} - the name of the PHP file that will be created.  L06 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/3/8 - the current system date.  11:02 - the current system time.  2022 - the current year.  03 - the current month.  08 - the current day of the month.  11 - the current hour.  02 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  三月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  三月 - full name of a month. Example: January, February, etc
 */
public class L06 {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    //
    //
    //
    //示例 1：
    //
    //输入：head = [1,3,2]
    //输出：[2,3,1]

  public class ListNode {
    int val;
    ListNode next;
   ListNode(int x) { val = x; }
  }


    public int[] reversePrint(ListNode head) {

        Stack<ListNode> answer=new Stack<>();

        ListNode now=head;

        while(now!=null){
            answer.push(now);
            now=now.next;
        }

        int size=answer.size();
        int[] realAnswer=new int[size];
        for(int i=0;i<size;i++){
            realAnswer[i]=answer.pop().val;
        }

        return realAnswer;
    }
}

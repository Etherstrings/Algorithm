package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etherstrings
 * @create 2023-07-05 19:55 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L143_new - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2023/7/5 - the current system date.  19:55 - the current system time.  2023 - the current year.  07 - the current month.  05 - the current day of the month.  19 - the current hour.  55 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  7月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  七月 - full name of a month. Example: January, February, etc
 */
public class L143_new {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        reorderList1(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public static void reorderList1(ListNode head) {
        if(head==null||head.next==null){
            return;
        }


        //1 2 3 4
        ListNode mid=findmid(head);


        //右半段
        ListNode rightpart=mid.next;
        mid.next=null;
        //左半段
        ListNode leftpart=head;

        //翻转后半部分
        ListNode pre = reverseList(rightpart);

        ListNode now=head;
        while(now!=null&&pre!=null){
            ListNode now_next=now.next;
            ListNode pre_next=pre.next;

            //1.前.next=后
            //2.前=后next
            //3.后.next=前
            //4.后=后Next
            now.next=pre;
            now=now_next;
            pre.next=now;
            pre=pre_next;
        }
    }
    public static ListNode findmid(ListNode head){
        ListNode f=head;
        ListNode s=head;
        //每次让f走两个 s走一个
        //最后s指向的就是中央节点
        while(f.next!=null&&f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
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
    public static void reorderList(ListNode head) {
        //1 2 3 4
        //1 4 2 3

        //1 2 3 4 5
        //1 5 2 4 3

        //0 n 1 n-1 2 n-2
        //ListNode转为ArrayList
        if(head==null){
            return;
        }
        List<Integer> list=LinkedList2ArrayList(head);
        List<Integer> ans=new ArrayList<>();
        if(list.size()%2==0){
            //4/2=2
            int mid=list.size()/2;
            //3
            int last=list.size()-1;
            for(int i=0;i<mid;i++){
                ans.add(list.get(i));
                ans.add(list.get(last-i));
            }
        }else {
            //5/2=2
            int mid=list.size()/2;
            int last=list.size()-1;
            for(int i=0;i<=mid;i++){
                if(i==mid){
                    ans.get(list.get(i));
                    continue;
                }
                ans.add(list.get(i));
                ans.add(list.get(last-i));
            }
        }
        ListNode n=Array2LinkedList(null,ans);
        head=new ListNode(-1,null);
        head=n;
    }
    public static List<Integer> LinkedList2ArrayList(ListNode head){
        if(head==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        ListNode now=head;
        while(now!=null){
            ans.add(now.val);
            now=now.next;
        }
        return ans;
    }
    public static ListNode Array2LinkedList(int[] array, List<Integer> arraylist){
        ListNode head=null;
        if(array==null&&arraylist==null){
            return head;
        }
        if(array==null){
            if(arraylist.size()==1){
                int temp=(int)arraylist.get(0);
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)arraylist.get(0);
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<arraylist.size();i++){
                int t=(int)arraylist.get(i);
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        if(arraylist==null){
            if(array.length==1){
                int temp=(int)array[0];
                head=new ListNode(temp);
                head.next=null;
                return head;
            }
            int temp=(int)array[0];
            head=new ListNode(temp);
            ListNode Now=head;
            ListNode Dummy=new ListNode(-1);
            Dummy.next=head;
            for(int i=1;i<array.length;i++){
                int t=(int)array[i];
                ListNode node=new ListNode(t);
                Now.next=node;
                Now=Now.next;
            }
            Now.next=null;
            return Dummy.next;
        }
        return head;
    }
}

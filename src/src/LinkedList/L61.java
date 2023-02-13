package src.LinkedList;

import LinkedList.ListNode;

/**
 * @author Etherstrings
 * @create 2022-06-09 12:56 LinkedList - the name of the target package where the new class or interface will be created.  Algorithm - the name of the current project.  null.java - the name of the PHP file that will be created.  L61 - the name of the new file which you specify in the New File dialog box during the file creation.  ps - the login name of the current user.  2022/6/9 - the current system date.  12:56 - the current system time.  2022 - the current year.  06 - the current month.  09 - the current day of the month.  12 - the current hour.  56 - the current minute.  IntelliJ IDEA - the name of the IDE in which the file will be created.  6月 - the first 3 letters of the month name. Example: Jan, Feb, etc.  六月 - full name of a month. Example: January, February, etc
 */
public class L61 {


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode Now=head;
        int i=2;
        while(i<6){
            Now.next=new ListNode(i);
            Now=Now.next;
            i++;
        };
        L61 l61 = new L61();
        l61.rotateRight(head,2);
        ListNode Cur=head;
        while(head!=null){
            System.out.print(Cur.val);
            Cur=Cur.next;
        }

    }


    //61. 旋转链表
    //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]
    //示例 2：
    //
    //
    //输入：head = [0,1,2], k = 4
    //输出：[2,0,1]
    //
    //
    //提示：
    //
    //链表中节点的数目在范围 [0, 500] 内
    //-100 <= Node.val <= 100
    //0 <= k <= 2 * 109
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        if(k==0){
            return head;
        }

        if(k==1&&head.next==null){
            return head;
        }
        //思路 首先肯定有虚拟头节点
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;




        //判断链表长度和K的长度
        int length=0;
        ListNode Now=Dummy;
        while(Now!=null)
        {
            length++;
            Now=Now.next;
        }
        length--;
        int test=k-length;


        if(test>0){
            //k大于链表长度
            //怎么挪？
            //按照相除的数来挪
            int Long=k%length;
            //余1 余2...


            //这个是余1
            if(Long==1){
                ListNode Cur=Dummy.next;
                ListNode slow=Dummy;

                while(Cur.next!=null){
                    Cur=Cur.next;
                    slow=slow.next;
                }
                //此时Cur指向链表的最后一个位置
                Cur.next=Dummy.next;
                slow.next=null;
                return Cur;
            }
            if(Long==0){
                return head;
            }

            //k<链表长度
            //思路 首先肯定有虚拟头节点
            ListNode NewNow=Dummy;
            ListNode Pre=Dummy;
            for(int i=0;i<Long;i++){
                NewNow=NewNow.next;
            }
            while (NewNow.next!=null){
                NewNow=NewNow.next;
                Pre=Pre.next;
            }
            // 0 1 2 3 4 5
            // 4 5 1 2 3
            //此时 NewNow是最末尾的
            //此时 Pre指在3 NewNow指在5

            //存下来head
            ListNode Temp=Dummy.next;
            //0指向4
            Dummy.next=Pre.next;
            //5指向1 也就是头节点
            NewNow.next=Temp;
            //3指向空指针
            Pre.next=null;

            //返回头指针
            return Dummy.next;

        }

        //k正好为链表的长度
        if(test==0){

            return head;
        }


        //k<链表长度
        //思路 首先肯定有虚拟头节点
        ListNode NewNow=Dummy;
        ListNode Pre=Dummy;
        for(int i=0;i<k;i++){
            NewNow=NewNow.next;
        }
        while (NewNow.next!=null){
            NewNow=NewNow.next;
            Pre=Pre.next;
        }
        // 0 1 2 3 4 5
        // 4 5 1 2 3
        //此时 NewNow是最末尾的
        //此时 Pre指在3 NewNow指在5

        //存下来head
        ListNode Temp=Dummy.next;
        //0指向4
        Dummy.next=Pre.next;
        //5指向1 也就是头节点
        NewNow.next=Temp;
        //3指向空指针
        Pre.next=null;

        //返回头指针
        return Dummy.next;

    }


}

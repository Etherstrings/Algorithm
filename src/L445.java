import LinkedList.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class L445 {
    //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    //
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    //
    //
    //
    //示例1：
    //
    //
    //
    //输入：l1 = [7,2,4,3], l2 = [5,6,4]
    //输出：[7,8,0,7]
    //示例2：
    //
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[8,0,7]
    //示例3：
    //
    //输入：l1 = [0], l2 = [0]
    //输出：[0]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //遍历取数 l1 l2
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        int int1=-1;
        int int2=-1;

        if(l1.val==0){
            int1=0;
        }else {
            ListNode now=l1;
            while(now!=null){
                list1.add(now.val);
                now=now.next;
            }
        }

        if(l2.val==0){
            int2=0;
        }else {
            ListNode now=l2;
            while(now!=null){
                list2.add(now.val);
                now=now.next;
            }
        }

        if(int1==0&&int2==0){
            ListNode head=new ListNode(0);
            head.next=null;
            return head;
        }

        if(int1==0&&int2!=0){
            return l2;
        }
        if(int1!=0&&int2==0){
            return l1;
        }

        //拼接l1 l2
        String num1="";
        String num2="";
        for(Integer a:list1){
            num1+=a;
        }
        for(Integer a:list2){
            num2+=a;
        }


        String temp=new BigInteger(num1).add(new BigInteger(num2)).toString();

        ListNode Dummy=new ListNode(-1);

        ListNode Now=Dummy;
        for(int i=0;i<temp.length();i++){
            Now.next=new ListNode(Integer.parseInt(Character.toString(temp.charAt(i))));
            Now=Now.next;
            if(i==temp.length()-1){
                Now.next=null;
            }
        }
        return Dummy.next;

    }


}

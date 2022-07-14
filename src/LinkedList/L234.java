package LinkedList;

import java.util.Arrays;

public class L234 {
    //给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,2,1]
    //输出：true
    //示例 2：
    //
    //
    //输入：head = [1,2]
    //输出：false
    public boolean isPalindrome(ListNode head) {
        //思路有好几种
        //1.遍历存---判断是不是回文--两个for
        //2.遍历存---String--直接reverse--判断
        //3.双指针---left在head right在末尾
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        StringBuilder a=new StringBuilder();
        ListNode Now=head;
        while (Now!=null){
            a.append(Now.val);
            Now=Now.next;
        }
        String temp=a.toString();
        String reverse = a.reverse().toString();
        if(reverse.equals(temp)){
            return true;
        }
        return false;
    }
}

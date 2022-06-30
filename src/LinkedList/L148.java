package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class L148 {
    //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [4,2,1,3]
    //输出：[1,2,3,4]
    //示例 2：
    //
    //
    //输入：head = [-1,5,3,4,0]
    //输出：[-1,0,3,4,5]
    //示例 3：
    //
    //输入：head = []
    //输出：[]
    public ListNode sortList(ListNode head) {
        //遍历再重新赋值？
        //可行-思路1
        ListNode Dummy=new ListNode(-1);
        Dummy.next=head;

        ArrayList<Integer> Judge=new ArrayList<>();

        ListNode now=Dummy;
        while(now!=null){
            Judge.add(now.val);
            now=now.next;
        }

        Judge.remove(0);
        if(Judge.size()==0){
            return null;
        }
        Collections.sort(Judge);
        int i=0;
        ListNode newhead=new ListNode(Judge.get(0));
        now=newhead;
        for(Integer a:Judge){
            if(i==0){
                i++;
                continue;
            }
            //指定下一位
            now.next=new ListNode(Judge.get(i));
            //移动now
            now=now.next;
            if(i==Judge.size()-1){
                now.next=null;
                break;
            }
            i++;
        }
        //左右比较？
        //也可行
        return newhead;
    }
}

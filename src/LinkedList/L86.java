package LinkedList;

import Tool.ATool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Justice_wby
 * @create 2023-01-28 23:40
 */
public class L86 {
    //86. 分隔链表
    //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //
    //你应当 保留 两个分区中每个节点的初始相对位置。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,4,3,2,5,2], x = 3
    //输出：[1,2,2,4,3,5]
    public ListNode partition(ListNode head, int x) {
        ListNode now=head;
        List<Integer> lower=new ArrayList<>();
        List<Integer> bigger=new ArrayList<>();
        while(now!=null){
            if(now.val==x){
                continue;
            }else if(now.val<x){
                lower.add(now.val);
            }else {
                bigger.add(now.val);
            }
            now=now.next;
        }
        List<Integer> all=new ArrayList<>();
        for(int n:lower){
            all.add(n);
        }
        all.add(x);
        for(int n:bigger){
            all.add(n);
        }
        return ATool.Array2LinkedList(null,all);

    }
}

package LinkedList;

import java.util.PriorityQueue;

public class L23 {
    //给你一个链表数组，每个链表都已经按升序排列。
    //
    //请你将所有链表合并到一个升序链表中，返回合并后的链表。
    //
    //
    //
    //示例 1：
    //
    //输入：lists = [[1,4,5],[1,3,4],[2,6]]
    //输出：[1,1,2,3,4,4,5,6]
    //解释：链表数组如下：
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //将它们合并到一个有序链表中得到。
    //1->1->2->3->4->4->5->6

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //优先队列
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((x,y) -> x.val - y.val);
        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                minHeap.offer(node.next);
            }
        }
        return dummy.next;

    }
}

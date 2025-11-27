package WorkReview.CralBook.LinkedListProblem;

public class L142CycleList {

    //给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    //
    //不允许修改 链表
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //先判断是不是有环,记得fast走2，slow走1，相遇就是有环


        // 1 2 3 4 5


        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环，找到环入口
                ListNode temp = head;
                while(temp!=slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}

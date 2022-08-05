package LinkedList;

public class L19 {
    //19. 删除链表的倒数第 N 个结点
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //示例 2：
    //
    //输入：head = [1], n = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [1,2], n = 1
    //输出：[1]
    //
    //
    //提示：
    //
    //链表中结点的数目为 sz
    //1 <= sz <= 30
    //0 <= Node.val <= 100
    //1 <= n <= sz
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode Dummy=new ListNode(-1,head);
        ListNode Fast=Dummy;
        ListNode slow=Dummy;
        for(int i=0;i<n+1;i++){
            Fast=Fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode pre = null;
        while (Fast != null) {
            pre = slow;
            slow = slow.next;
            Fast = Fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        pre.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return Dummy.next;
    }
}
